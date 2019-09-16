package com.geckop.spring.banckend.geckop.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDRadioButton;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;
import com.geckop.spring.banckend.geckop.models.entity.GastoViaje;
import com.geckop.spring.banckend.geckop.models.entity.Orden;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;

import com.geckop.spring.banckend.geckop.models.services.IOrdenService;




@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com", "https://geckop-dd655.firebaseapp.com", "https://geckop-dd655.web.app"})
@RestController
@RequestMapping("/api")
public class OrdenRestController {
	@Autowired
	private IOrdenService ordenService;
	
	// Nos devuelve toda la lista de ordenes
	@GetMapping("/ordenes")
	public List<Orden> index() {
		return ordenService.findAll();
	}
	
	//Va a retornar la orden convertida en json
	@GetMapping("/ordenes/{id}")
	public Orden show(@PathVariable Long id) {
		return ordenService.buscarOrdenPorId(id);
	}
		
	// Buscamos una orden por su acronimo y numeracion
	public Orden buscarOrden(Orden orden) {
		return ordenService.buscarOrdenPorAcryNum(orden.getAcronimo(), orden.getNumeracion());
	}

	
	// Crea una orden
	@PostMapping("/ordenes")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden crearOrden(@RequestBody Orden orden) {
		return ordenService.insertarOrden(orden);
	}
	
	// Elimina una orden
	//DELETE POSTMAN-http://localhost:8080/api/ordenes/
	@DeleteMapping("/ordenes/{id}")
	public void borrarOrden(@PathVariable Long id) {
		ordenService.eliminarOrden(id);
	}
	
	/*Va a retornar la lista de nuestras ordenes*/
	@PostMapping(path="/buscarordenesnif")
	public List<Orden> buscarOrdenNif(@RequestBody String n) {
		 List<Orden> o = ordenService.findByNif(n);
		 return o;
	}
	

	/*Nos retorna la numeracion siguiente dependiendo del proyecto que seleccionemos para la orden*/
	@PostMapping(path="/buscarnumacronimo")
	public Long buscarNumeracionSiguiente(@RequestBody String a) {
		Long num = ordenService.buscarNumeracionSiguiente(a);
		return num;
	}

	
	@PostMapping(path="/ordenesdeip")
	List<Orden> getOrdenesPendientesDeFirmaDeIP(@RequestBody String ip){
		 List<Orden> o = ordenService.getOrdenesPendientesDeFirmaDeIP(ip);
		 return o;
	}
	
	@PostMapping(path="/getordenid")
	Orden getOrdenID(@RequestBody Long id){
		 Orden o = ordenService.buscarOrdenPorId(id);
		 return o;
	}
	
	@PostMapping(path="/setorden")
	Orden setOrden(@RequestBody Orden o){
		 return ordenService.update(o);	 
	}
	
	@PostMapping(path="/getordenproyecto")
	List<Orden> getOrdenPorProyecto(@RequestBody String id){
		List<Orden> o = ordenService.buscarOrdenPorProyecto(id);
		 return o;
	}
	
	
	
	/*FUNICONES PARA LOS PDF*/
	@PostMapping(path="/generarPDF")
	Long generarPDF (@RequestBody Orden o){
		Boolean tipoG = o.getTipo().equals("G");
		try {
			Path rutaArchivo = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
				
	        File file = new File(rutaArchivo.toString());
	        
			PDDocument pdfDocument = PDDocument.load(file);
			PDAcroForm pdfFields = pdfDocument.getDocumentCatalog().getAcroForm();
			 if (pdfFields != null)
			 {
             // Retrieve an individual field and set its value.
                //PDTextField field = (PDTextField) acroForm.getField( "sampleField" );
                //List<PDField> pdfFields = acroForm.getFields();
                
                ((PDTextField) pdfFields.getField("NUM_ORDEN")).setValue(o.getNumeracion().toString());
    			((PDTextField) pdfFields.getField("FECHA")).setValue(o.getFechaOrden().toString());
    			((PDTextField) pdfFields.getField("REF_PROYECTO")).setValue(o.getAcronimo());
    			((PDTextField) pdfFields.getField("IBAN")).setValue(o.getIban());
    			//((PDTextField) pdfFields.getField("BIC")).setValue("");
    			
    			if(tipoG) {

        			((PDTextField) pdfFields.getField("RELACION")).setValue(o.getRelacion());
        			((PDTextField) pdfFields.getField("NUM_CONTAB")).setValue(o.getNum_contabilidad());
        			((PDTextField) pdfFields.getField("MEMORIA")).setValue(o.getMemoria());
        			((PDTextField) pdfFields.getField("OBSERVAC")).setValue(o.getObservaciones());
      
        			//Rellenar acreedor
        			((PDTextField) pdfFields.getField("NOMBRE_PAGAR")).setValue(o.getNif_acreedor());
 
    			}else {
    			 				
    				// Irá por separado((PDTextField) pdfFields.getField("VIAJANTE")).setValue(o.getIban());
    				
    				
    				if(o.getRelacion().equals("Miembro del proyecto"))
    					((PDRadioButton) pdfFields.getField("RELACION_PROYECTO")).setValue("miembro_proy");
    				else if(o.getRelacion().equals("Profesor Invitado"))
    					((PDRadioButton) pdfFields.getField("RELACION_PROYECTO")).setValue("prof_invitado");
    				else if(o.getRelacion().equals("Miembro del equipo de trabajo"))
    					((PDRadioButton) pdfFields.getField("RELACION_PROYECTO")).setValue("miembro_equipo");
    			
    					
    					
    				((PDTextField) pdfFields.getField("OBSERVACIONES")).setValue(o.getObservaciones());
    				((PDTextField) pdfFields.getField("OBJETO_VIAJE")).setValue(o.getMemoria());
        			((PDTextField) pdfFields.getField("NUM_CONTABILIDAD")).setValue(o.getNum_contabilidad());
    			}
            }
				
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 
			
			 
			 
			return 0L;
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		}
		
	}
	
	
	@PostMapping(path="/rellenarIPPDF")
	Long rellenarDatosIP(@RequestBody Usuario ip){
		
		File f = new File("pdfs");
		f.mkdir();
		
		//Path rutaArchivo = Paths.get("pdfs").resolve("ordenGeneral.pdf").toAbsolutePath();
        	
		try {
			URL u = new URL("http://antares.sip.ucm.es/manolo/formularios/32-2018-10-25-20181025_doc1_frm_orden_pago_gastos_generales.pdf");
			/*u.toURI();
			File file = new File(u.toURI());*/
			InputStream file = u.openStream();
        	
			PDDocument pdfDocument = PDDocument.load(file);
			PDAcroForm pdfFields = pdfDocument.getDocumentCatalog().getAcroForm();
			 if (pdfFields != null)
			 {
				((PDTextField) pdfFields.getField("NOMBRE_IP")).setValue(ip.getNombre() + " " + ip.getApellido1() + " "+ ip.getApellido2());
				((PDTextField) pdfFields.getField("DPTO_IP")).setValue(ip.getDepartamento());
				((PDTextField) pdfFields.getField("CTRO_IP")).setValue(ip.getCentro());
				((PDTextField) pdfFields.getField("NIF_IP")).setValue(ip.getDni());
				((PDTextField) pdfFields.getField("TLF_IP")).setValue(ip.getTelefono());
				((PDTextField) pdfFields.getField("EMAIL_IP")).setValue(ip.getEmail());	
				
			 }
			 
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 return 0L;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0L;
		} 
	}
	@PostMapping(path="/rellenarIPPDFV")
	Long rellenarDatosIPV(@RequestBody Usuario ip){
		
		
		
		/*Path rutaArchivo = Paths.get("pdfs").resolve("ordenViajes.pdf").toAbsolutePath();
        File file = new File(rutaArchivo.toString());*/
        		
		try {
			URL u = new URL("http://antares.sip.ucm.es/manolo/formularios/32-2018-07-06-doc2_frm_orden_pago_viajes.pdf");
			/*u.toURI();
			File file = new File(u.toURI());*/
			InputStream file = u.openStream();
			PDDocument pdfDocument = PDDocument.load(file);
			PDAcroForm pdfFields = pdfDocument.getDocumentCatalog().getAcroForm();
			 if (pdfFields != null)
			 {
				((PDTextField) pdfFields.getField("NOMBRE_INVESTIGADOR")).setValue(ip.getNombre() + " " + ip.getApellido1() + " "+ ip.getApellido2());
 				((PDTextField) pdfFields.getField("NIF")).setValue(ip.getDni());
 				((PDTextField) pdfFields.getField("TELEFONO")).setValue(ip.getTelefono());
 				((PDTextField) pdfFields.getField("EMAIL")).setValue(ip.getEmail());	
 				((PDTextField) pdfFields.getField("DEPARTAMENTO")).setValue(ip.getDepartamento());
 				((PDTextField) pdfFields.getField("CENTRO")).setValue(ip.getCentro());
			 }
			 
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 return 0L;
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} 
	}
	
	@PostMapping(path="/rellenarGastosPDF")
	Long rellenarGastosPDF(@RequestBody List<Gasto> gastos){
		
		Path rutaArchivo = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
        File file = new File(rutaArchivo.toString());
        		
		try {
			PDDocument pdfDocument = PDDocument.load(file);
			PDAcroForm pdfFields = pdfDocument.getDocumentCatalog().getAcroForm();
			 if (pdfFields != null)
			 {
				for(int i = 0; i < gastos.size(); i++) {				
					((PDTextField) pdfFields.getField("PROV_FAC_"+(i+1))).setValue(gastos.get(i).getDescripcion());
					((PDTextField) pdfFields.getField("NUM_FAC_"+(i+1))).setValue(gastos.get(i).getnFactura());
					((PDTextField) pdfFields.getField("IMP_FAC_"+(i+1))).setValue(String.valueOf(gastos.get(i).getImporte()));
				}
			 }
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 return 0L;
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} 
	}
	
	@PostMapping(path="/rellenarGastoPDFV")
	Long rellenarGastosPDFV(@RequestBody GastoViaje g){
		
		Path rutaArchivo = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
        File file = new File(rutaArchivo.toString());
        		
		try {
			PDDocument pdfDocument = PDDocument.load(file);
			PDAcroForm pdfFields = pdfDocument.getDocumentCatalog().getAcroForm();
			 if (pdfFields != null)
			 {
			 	((PDTextField) pdfFields.getField("ITINERARIO")).setValue(g.getItinerario());	
			  	((PDTextField) pdfFields.getField("FECHA_IDA")).setValue(g.getFechaIda().toString());
			  	((PDTextField) pdfFields.getField("FECHA_VUELTA")).setValue(g.getFechaVuelta().toString());
				((PDTextField) pdfFields.getField("AVION")).setValue(String.valueOf(g.getImporteAvion()));
				((PDTextField) pdfFields.getField("COCHE")).setValue(String.valueOf(g.getImporteCoche()));
				((PDTextField) pdfFields.getField("TREN")).setValue(String.valueOf(g.getImporteTren()));
				((PDTextField) pdfFields.getField("BUS")).setValue(String.valueOf(g.getImporteAutobus()));
				((PDTextField) pdfFields.getField("TAXI")).setValue(String.valueOf(g.getImporteTaxi()));
				((PDTextField) pdfFields.getField("HOTEL")).setValue(String.valueOf(g.getImporteHotel()));
				((PDTextField) pdfFields.getField("OTROS")).setValue(String.valueOf(g.getImporteOtros()));
				((PDTextField) pdfFields.getField("DESCR_OTROS")).setValue(g.getOtros());
				((PDTextField) pdfFields.getField("NUM_DIETAS")).setValue(String.valueOf(g.getnDietas()));
				((PDTextField) pdfFields.getField("IMP_DIETA")).setValue(String.valueOf(g.getPrecioDieta()));
				((PDTextField) pdfFields.getField("TOTAL_DIETAS")).setValue(String.valueOf(g.getImporteDietas()));
				((PDTextField) pdfFields.getField("CONGRESOS")).setValue(String.valueOf(g.getImporteOtrosGastos()));
				((PDTextField) pdfFields.getField("KILOMETROS")).setValue(String.valueOf(g.getNkilometros()));
				if(g.getCheckAgenciaAvion())
				((PDCheckBox) pdfFields.getField("AG_AVION")).check();
				if(g.getCheckAgenciaTren())
				((PDCheckBox) pdfFields.getField("AG_TREN")).check();
				if(g.getCheckAgenciaAlojamiento())
				((PDCheckBox) pdfFields.getField("AG_ALOJA")).check();
				((PDTextField) pdfFields.getField("AG_OTRO_DESC")).setValue(g.getOtrosAgencia());;
				((PDTextField) pdfFields.getField("TOTAL_GASTOS")).setValue(String.valueOf(g.getImporteTotal()));
				((PDTextField) pdfFields.getField("EURXKM")).setValue(String.valueOf(g.getPrecioKilometro()));

			 }
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 return 0L;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0L;
		} 
	}
	
	
	@PostMapping(path="/probarRuta")
	public Long probarRutas(){
		File f = new File("imagenes");
		System.out.println(f.getAbsolutePath());
		f.mkdir();
		System.out.println(f.getAbsolutePath());
		
		
		return 0L;
	}
	
	@RequestMapping(value = "/mostrarPDF/{id}", method=RequestMethod.GET,  produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> mostrarPDF(@PathVariable("id")Long idOrden){
    	
    	Path rutaArchivo = Paths.get("pdfs").resolve("auxPdf.pdf").toAbsolutePath();
		
		File f = new File(rutaArchivo.toString());
		f.getAbsolutePath();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(f.getAbsolutePath());
			 //String inputStreamToString = inputStream.toString();
			 
	        byte[] content =   IOUtils.toByteArray(inputStream);
	        return new ResponseEntity<>(content, this.getPDFHeaders("auxPdf.pdf"), HttpStatus.OK);
	   
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public HttpHeaders getPDFHeaders(String fileName) {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.parseMediaType("application/pdf"));
        head.add("content-disposition", "attachment; filename=" + fileName);
        head.setContentDispositionFormData(fileName, fileName);
        head.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return head;
    }

	
	
}

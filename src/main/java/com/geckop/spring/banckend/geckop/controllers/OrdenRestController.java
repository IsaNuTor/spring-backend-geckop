package com.geckop.spring.banckend.geckop.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.geckop.spring.banckend.geckop.models.entity.Orden;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;
import com.geckop.spring.banckend.geckop.models.services.IOrdenService;
import com.geckop.spring.banckend.geckop.models.services.IUsuarioProyectoService;
import com.geckop.spring.banckend.geckop.models.services.IUsuarioService;
import com.geckop.spring.banckend.geckop.models.services.UsuarioServiceImplement;


@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
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
	
	@PostMapping(path="/generarPDF")
	Long generarPDF (@RequestBody Orden o){
		try {
			//URL u = new URL("https://www.ucm.es/data/cont/docs/32-2018-10-25-20181025_doc1_frm_orden_pago_gastos_generales.pdf");
		
			Path rutaArchivo = Paths.get("pdfs").resolve("ordenGeneral.pdf").toAbsolutePath();
			
	        //text file, should be opening in default text editor
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
    			((PDTextField) pdfFields.getField("NUM_CONTAB")).setValue(o.getNum_contabilidad());
                
                
                
                
                //field.setValue("Text Entry");
                
                // If a field is nested within the form tree a fully qualified name
                // might be provided to access the field.
                //field = (PDTextField) acroForm.getField( "fieldsContainer.nestedSampleField" );
                //field.setValue("Text Entry");
            }
				
			 Path rutaArchivo2 = Paths.get("pdfs").resolve("pdf_prueba.pdf").toAbsolutePath();
			 pdfDocument.save(rutaArchivo2.toString());
			 pdfDocument.close(); 
			 
			 
			 
			return 0L;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0L;
		}
		
	}
		 
	
	
}

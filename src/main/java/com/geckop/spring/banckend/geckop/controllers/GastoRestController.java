package com.geckop.spring.banckend.geckop.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;
import com.geckop.spring.banckend.geckop.models.services.IGastoService;

@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com", "https://geckop-dd655.firebaseapp.com", "https://geckop-dd655.web.app"})
@RestController
@RequestMapping("/api")
public class GastoRestController {
	@Autowired
	private IGastoService gastoService;
	
	private final Logger log = LoggerFactory.getLogger(GastoRestController.class);
	
	@GetMapping("/gastos")
	public List<Gasto> index() {
		return gastoService.findAll();
	}
	
	@GetMapping("/gastos/{id}")
	public Gasto show(@PathVariable Long id) {
		return gastoService.buscarGastoPorId(id);
	}
	
	// Retorna el gasto que se creó en la base de datos.
	// Como viene en formato json desde Angular, indicamos
	// al parámetro de entrada que es un @RequestBody
	@PostMapping("/gastos")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto crearGasto(@RequestBody Gasto gasto) {
		return gastoService.insertarGasto(gasto);
	}
	
	// borrar, y le pasamos el id del gasto que queremos eliminar.
	@DeleteMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarGasto(@PathVariable Long id) {
		
		//Primero eliminamos la foto de la carpeta imagenes asociada a ese gasto
		Gasto gasto = gastoService.buscarGastoPorId(id);
		
		// Si el usuario ya ha subido una foto para ese gasto, tenemos que eliminarla
		String nombreArchivoAnterior = gasto.getFoto();
		
		if(nombreArchivoAnterior !=null && nombreArchivoAnterior.length() > 0) {
			Path rutaArchivoAnterior = Paths.get("imagenes").resolve(nombreArchivoAnterior).toAbsolutePath();
			File archivoImagenAnterior = rutaArchivoAnterior.toFile();
			if(archivoImagenAnterior.exists()) {
				archivoImagenAnterior.delete();
			}
		}
		
		// Eliminamos el gasto.
		gastoService.eliminarGasto(id);
	}
	
	@PostMapping("/setGasto")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean setGasto(@RequestBody Gasto gasto) {
		
		System.out.println(gasto.getId());
		System.out.println(gasto.getId_orden());
		System.out.println(gasto.getFoto());
		
		Gasto g = gastoService.buscarGastoPorId(gasto.getId());
		g.setId_orden(gasto.getId_orden());
		
		return gastoService.update(g);
	}
	
	// Actualizar id_orden del gasto
	/*@PutMapping("/gastos/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean subirIdOrden(@RequestBody Gasto gasto, @PathVariable Long id) {
		// Primero tenemos que obtener el acreedor de la base de datos.
		Gasto gastoActual = gastoService.buscarGastoPorId(id);
		
		// Al gasto de la base de datos, ponemos los datos que nos vienen.
		gastoActual.setId_orden(gasto.getId_orden());

		return gastoService.update(gastoActual);
	}*/
			
	// Subida de la imagen
	@PostMapping("/gastos/subirImagen")
	public ResponseEntity<?> subirImagen(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Gasto gasto = gastoService.buscarGastoPorId(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = id.toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			File f = new File("imagenes");
			f.mkdir();
			Path rutaArchivo = Paths.get("imagenes").resolve(nombreArchivo).toAbsolutePath();
		
			// Mostrar por consola del eclipse la ruta del archivo
			log.info(rutaArchivo.toString());
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen" + nombreArchivo);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			gasto.setFoto(nombreArchivo);
			gastoService.insertarGasto(gasto);
			
			response.put("gasto", gasto);
			response.put("mensaje", "imagen subida correctamente" + nombreArchivo);
	
		}	
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/imagenes/{nombreFoto:.+}")
	public ResponseEntity<Resource> mostrarFoto(@PathVariable String nombreFoto) {
		File f = new File("imagenes");
		f.mkdir();
		
		
		Path rutaArchivo = Paths.get("imagenes").resolve(nombreFoto).toAbsolutePath();
		
		// Mostrar por consola del eclipse la ruta del archivo
		log.info(rutaArchivo.toString());
		
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		if(!recurso.exists()) {
			throw new RuntimeException("No se pudo cargar la imagen" + nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename()+"\"");
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
	@PostMapping(path="/gastos/byidorden")
	public List<Gasto> findByIdOrden(@RequestBody Long id_o){
		return gastoService.findByIdOrden(id_o);
	}
}

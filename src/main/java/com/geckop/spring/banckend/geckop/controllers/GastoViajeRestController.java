package com.geckop.spring.banckend.geckop.controllers;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;
import com.geckop.spring.banckend.geckop.models.entity.GastoViaje;
import com.geckop.spring.banckend.geckop.models.services.IGastoViajeService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com", "https://geckop-dd655.firebaseapp.com", "https://geckop-dd655.web.app"})
@RestController
@RequestMapping("/api")
public class GastoViajeRestController {
	
	@Autowired
	private IGastoViajeService gastoViajeService;
	
	private final Logger log = LoggerFactory.getLogger(GastoRestController.class);
	
	@GetMapping("/gastosViaje")
	public List<GastoViaje> index() {
		return gastoViajeService.findAll();
	}
	
	@GetMapping("/gastosViaje/{id}")
	public GastoViaje show(@PathVariable Long id) {
		return gastoViajeService.buscarGastoViajePorId(id);
	}
	
	// Retorna el gasto que se creó en la base de datos.
	// Como viene en formato json desde Angular, indicamos
	// al parámetro de entrada que es un @RequestBody
	@PostMapping("/gastosViaje")
	@ResponseStatus(HttpStatus.CREATED)
	public GastoViaje crearGastoViaje(@RequestBody GastoViaje gastoViaje) {
		return gastoViajeService.insertarGastoViaje(gastoViaje);
	}
	
	// borrar, y le pasamos el id del gasto que queremos eliminar.
/*	@DeleteMapping("/gastosViaje/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarGastoViaje(@PathVariable Long id, @RequestBody String foto) {
		
		//Primero eliminamos la foto de la carpeta imagenes asociada a ese gasto
		GastoViaje gastoViaje = gastoViajeService.buscarGastoViajePorId(id);
		
		// Si el usuario ya ha subido una foto para ese gasto, tenemos que eliminarla
		String nombreArchivoAnterior = foto;
		
		if(nombreArchivoAnterior !=null && nombreArchivoAnterior.length() > 0) {
			Path rutaArchivoAnterior = Paths.get("imagenes").resolve(nombreArchivoAnterior).toAbsolutePath();
			File archivoImagenAnterior = rutaArchivoAnterior.toFile();
			if(archivoImagenAnterior.exists()) {
				archivoImagenAnterior.delete();
			}
		}
		
		// Eliminamos el gasto.
		gastoViajeService.eliminarGastoViaje(id);
	}
*/
	@PostMapping("/setGastoViaje")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean setGasto(@RequestBody GastoViaje gastoViaje) {
		
		/*System.out.println(gasto.getId());
		System.out.println(gasto.getId_orden());
		System.out.println(gasto.getFoto());*/
		
		GastoViaje g = gastoViajeService.buscarGastoViajePorId(gastoViaje.getId());
		g.setId_orden(gastoViaje.getId_orden());
		
		return gastoViajeService.update(g);
	}
	
	// Actualizar id_orden del gasto
	@PutMapping("/gastosViaje/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean subirIdOrden(@RequestBody GastoViaje gasto, @PathVariable Long id) {
		// Primero tenemos que obtener el acreedor de la base de datos.
		GastoViaje gastoActual = gastoViajeService.buscarGastoViajePorId(id);
		
		// Al gasto de la base de datos, ponemos los datos que nos vienen.
		gastoActual.setId_orden(gasto.getId_orden());

		return gastoViajeService.update(gastoActual);
	}
			
	// Subida de la imagen
	@PostMapping("/gastosViaje/subirImagen")
	public ResponseEntity<?> subirImagen(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = id.toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("imagenesViajes").resolve(nombreArchivo).toAbsolutePath();
		
			// Mostrar por consola del eclipse la ruta del archivo
			log.info(rutaArchivo.toString());
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen" + nombreArchivo);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			//gastoViaje.setFoto(nombreArchivo);
			//gastoViajeService.insertarGasto(gasto);
			
			//response.put("gasto", gasto);
			//response.put("mensaje", "imagen subida correctamente" + nombreArchivo);
	
		}	
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/imagenesViajes/{nombreFoto:.+}")
	public ResponseEntity<Resource> mostrarFoto(@PathVariable String nombreFoto) {
		
		Path rutaArchivo = Paths.get("imagenesViajes").resolve(nombreFoto).toAbsolutePath();
		
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
	
	@PostMapping(path="/gastosViaje/byidorden")
	public GastoViaje findByIdOrden(@RequestBody Long id_o){
		return gastoViajeService.findByIdOrden(id_o);
	}
}

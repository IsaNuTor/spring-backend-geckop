package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

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
import com.geckop.spring.banckend.geckop.models.services.IOrdenService;


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
	
	// Buscamos una orden por su acronimo y numeracion
	public Orden buscarOrden(Orden orden) {
		return ordenService.buscarOrdenPorAcryNum(orden.getAcronimo(), orden.getNumeracion());
	}
	
	/*//POSTMAN-http://localhost:8080/api/ordenes/acr/1200
	@GetMapping("/ordenes/{acronimo}/{numeracion}")
	public Orden buscarOrden(@PathVariable String acronimo, @PathVariable Long numeracion) {

		return ordenService.buscarOrdenPorAcryNum(acronimo, numeracion);
	}*/
	
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
	
}

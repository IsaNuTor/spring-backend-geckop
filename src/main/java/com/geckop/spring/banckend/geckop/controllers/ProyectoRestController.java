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

import com.geckop.spring.banckend.geckop.models.entity.Proyecto;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;
import com.geckop.spring.banckend.geckop.models.services.IProyectoService;

//Damos acceso a este dominio para que pueda enviar y recibir datos.
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProyectoRestController {
	@Autowired
	private IProyectoService proyectoService;
	
	 @PostMapping(path="/proyecto")
	public Proyecto insertarProyecto(@RequestBody Proyecto proyecto) {
		if(!this.buscarProyecto(proyecto.getAcronimo()) )
			return proyectoService.insertarProyecto(proyecto);
		else
			return null;
	}
	 
	 /*Va a retornar la lista de usuarios en json*/
	@GetMapping("/proyecto")
	public List<Proyecto> index() {
		return proyectoService.findAll();
	}
	
	@DeleteMapping("/proyecto/{acronimo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean borrarProyecto(@PathVariable String acronimo) {
		try {
			proyectoService.borrarProyecto(acronimo);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
		
	}
	
	public boolean buscarProyecto(String id) {
		try {
			proyectoService.buscarProyecto(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}

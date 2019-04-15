package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
 		return proyectoService.insertarProyecto(proyecto);
	}
	 
	 /*Va a retornar la lista de usuarios en json*/
	@GetMapping("/proyecto")
	public List<Proyecto> index() {
		return proyectoService.findAll();
	}

}

package com.geckop.spring.banckend.geckop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;
import com.geckop.spring.banckend.geckop.models.services.IUsuarioProyectoService;

//Damos acceso a este dominio para que pueda enviar y recibir datos.
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioProyectoRestController {
	@Autowired
	private IUsuarioProyectoService usuarioProyectoService;
	
	@PostMapping(path="/usuarioproyecto")
	public UsuarioProyecto insertarUsuarioProyecto(@RequestBody UsuarioProyecto usuarioProyecto) {
		return usuarioProyectoService.insertarUsuarioProyecto(usuarioProyecto);
	}

}

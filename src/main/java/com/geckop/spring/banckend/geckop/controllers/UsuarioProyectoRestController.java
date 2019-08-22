package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;
import com.geckop.spring.banckend.geckop.models.services.IUsuarioProyectoService;

//Damos acceso a este dominio para que pueda enviar y recibir datos.
@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
@RestController
@RequestMapping("/api")
public class UsuarioProyectoRestController {
	@Autowired
	private IUsuarioProyectoService usuarioProyectoService;
	
	@PostMapping(path="/usuarioproyecto")
	public UsuarioProyecto insertarUsuarioProyecto(@RequestBody UsuarioProyecto usuarioProyecto) {
		return usuarioProyectoService.insertarUsuarioProyecto(usuarioProyecto);
	}
	
	/*Va a retornar la lista de usuarios en json*/
	@PostMapping(path="/buscarusuariosproyecto")
	public List<UsuarioProyecto> buscarUsuariosProyecto(@RequestBody String p) {
		 List<UsuarioProyecto> u = usuarioProyectoService.findByProyect(p);
		 return u;
		//return usuarioProyectoService.findAll();
	}
	
	/*Va a retornar la lista de proyectos del usuario en json para orden*/
	@PostMapping(path="/buscarproyectosdni")
	public List<UsuarioProyecto> buscarProyectosDni(@RequestBody String p) {
		 List<UsuarioProyecto> u = usuarioProyectoService.findBydni(p);
		 return u;
	}

}

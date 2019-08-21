package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

public interface IUsuarioProyectoService {
	
	UsuarioProyecto insertarUsuarioProyecto(UsuarioProyecto usuarioProyecto);

	List<UsuarioProyecto> findByProyect(String p);
	List<UsuarioProyecto> findAll();
	
	// Proyectos por dni para orden
	List<UsuarioProyecto> findBydni(String p);
}

package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Proyecto;

public interface IProyectoService {
	
	public Proyecto insertarProyecto(Proyecto proyecto);

	public List<Proyecto> findAll();

	public void borrarProyecto(String acronimo);
	
	public Proyecto buscarProyecto(String id);
}

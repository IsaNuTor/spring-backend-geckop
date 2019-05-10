package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Orden;

public interface IOrdenService {
	// Nos devuelve la lista de todas las ordenes que hay guardadas en la tabla orden.
	public List<Orden> findAll();
	
	// Buscar una orden por proyecto y numeracion, nos devuelve la orden.
	public Orden buscarOrdenPorAcryNum(String acronimo, Long numeracion);
	
	// Nos devuelve la orden que se ha insertado en la tabla.
	public Orden insertarOrden(Orden orden);
	
	// Borrar en la tabla. Le pasamos id.
	public void eliminarOrden(String acron_id);
}

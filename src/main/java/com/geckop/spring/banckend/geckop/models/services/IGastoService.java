package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;

public interface IGastoService {
	
	// Nos devuelve la lista de todos los gastos que hay guardados en la tabla gastos.
	public List<Gasto> findAll();
	
	// Buscar un gasto por id, nos devuelve el gasto.
	public Gasto buscarGastoPorId(Long id);
	
	// Nos devuelve el gasto que se ha insertado en la tabla. (ya contiene el id)
	public Gasto insertarGasto(Gasto gasto);
	
	// Borrar en la tabla. Le pasamos el id del gasto que vamos a eliminar de la tabla.
	public void eliminarGasto(Long id);
	
	public Boolean update(Gasto gasto);
}

package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.TipoGasto;

public interface ITipoGastoService {

	// Nos devuelve la lista de todos los tipos de gastos que hay guardados en la tabla tipogasto.
	public List<TipoGasto> findAll();
	
	// Buscar un tipogasto por id, nos devuelve el tipogasto.
	public TipoGasto buscarTipoGastoPorId(Long id);
	
	// Nos devuelve el tipogasto que se ha insertado en la tabla. (ya contiene el id)
	public TipoGasto insertarTipoGasto(TipoGasto tipoGasto);
	
	// Borrar en la tabla. Le pasamos el id del tipogasto que vamos a eliminar de la tabla.
	public void eliminarTipoGasto(Long id);
}

package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Acreedor;

public interface IAcreedorService {

	// Nos devuelve en formato lista el contenido de la tabla acreedor.
	public List<Acreedor> findAll();
	
	// Buscar un acreedor por id, nos devuelve el acreedor.
	public Acreedor buscarAcreedorPorId(String id);
	
	// Nos devuelve el acreedor que se ha insertado en la tabla. (ya contiene el id)
	public Acreedor insertarAcreedor(Acreedor acreedor);
	
	// Borrar en la tabla. Le pasamos el id del acreedor que vamos a eliminar de la tabla.
	//public void eliminarAcreedor(String id);
}

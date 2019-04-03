package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Acreedor;

public interface IAcreedorService {

	// Nos devuelve en formato lista el contenido de la tabla acreedor.
	public List<Acreedor> findAll();
	
	// Buscar un acreedor por nif, nos devuelve el acreedor.
	public Acreedor buscarAcreedorPorNif(String nif);
	
	// Nos devuelve el acreedor que se ha insertado en la tabla. (ya contiene el nif)
	public Acreedor insertarAcreedor(Acreedor acreedor);
	
	// Borrar en la tabla. Le pasamos el nif del acreedor que vamos a eliminar de la tabla.
	public void eliminarAcreedor(String nif);
}

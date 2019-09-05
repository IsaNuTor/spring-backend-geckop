package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.GastoViaje;

public interface IGastoViajeService {

	// Nos devuelve la lista de todos los gastos de viaje que hay guardados en la tabla gastos.
	public List<GastoViaje> findAll();
		
	// Buscar un gasto por id, nos devuelve el gasto.
	public GastoViaje buscarGastoViajePorId(Long id);
	
	// Nos devuelve el gasto que se ha insertado en la tabla. (ya contiene el id)
	public GastoViaje insertarGastoViaje(GastoViaje gastoViaje);
	
	// Borrar en la tabla. Le pasamos el id del gasto que vamos a eliminar de la tabla.
	public void eliminarGastoViaje(Long id);
	
	// Actualizar la id_orden, para saber de que orden es el gasto.
	public Boolean update(GastoViaje gastoViaje);

	public GastoViaje findByIdOrden(Long id_o);
}

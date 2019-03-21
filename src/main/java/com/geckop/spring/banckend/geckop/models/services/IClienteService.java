package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Cliente;

public interface IClienteService {
	
	// Nos devuelve la lista de todos los clientes que hay guardados en la tabla clientes.
	public List<Cliente> findAll();
	
	// Buscar un cliente por id, nos devuelve el cliente.
	public Cliente buscarClientePorId(Long id);
	
	// Nos devuelve el cliente que se ha insertado en la tabla. (ya contiene el id)
	public Cliente insertarCliente(Cliente cliente);
	
	// Borrar en la tabla. Le pasamos el id del cliente que vamos a eliminar de la tabla.
	public void eliminarCliente(Long id);
	
}

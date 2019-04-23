package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.Cliente;
import com.geckop.spring.banckend.geckop.models.services.IClienteService;

// Damos acceso a este dominio para que pueda enviar y recibir datos.
@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	//Va a retornar el cliente convertido en json
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.buscarClientePorId(id);
	}
	
	// Retorna el cliente que se creó en la base de datos.
	// Como viene en formato json desde Angular, indicamos
	// al parámetro de entrada que es un @RequestBody
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return clienteService.insertarCliente(cliente);
	}
	
	// Para actualizar, necesitamos también el id para poder
	// obtenerlo de la base de datos y actualizar sus atributos.
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente modificarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		// Primero tenemos que obtener el cliente de la base de datos.
		Cliente clienteActual = clienteService.buscarClientePorId(id);
		
		// Al cliente de la base de datos, ponemos los datos que nos vienen.
		clienteActual.setApellidos(cliente.getApellidos());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.insertarCliente(clienteActual);
	}
	
	// borrar, y le pasamos el id del cliente que queremos eliminar.
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarCliente(@PathVariable Long id) {
		clienteService.eliminarCliente(id);
	}
}

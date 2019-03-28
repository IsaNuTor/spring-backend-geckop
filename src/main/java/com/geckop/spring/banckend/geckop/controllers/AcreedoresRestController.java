package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.Acreedor;
import com.geckop.spring.banckend.geckop.models.services.IAcreedorService;

// Damos acceso a este dominio para que pueda enviar y recibir datos.
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AcreedoresRestController {
	
	@Autowired
	private IAcreedorService acreedorService;
	
	@GetMapping("/acreedores")
	public List<Acreedor> index() {
		return acreedorService.findAll();
	}
	
	//Va a retornar el acreedor convertido en json
	@GetMapping("/acreedores/{id}")
	public Acreedor show(@PathVariable String id) {
		return acreedorService.buscarAcreedorPorId(id);
	}
	
	// Retorna el acreedor que se creó en la base de datos.
	// Como viene en formato json desde Angular, indicamos
	// al parámetro de entrada que es un @RequestBody
	@PostMapping("/acreedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Acreedor crearAcreedor(@RequestBody Acreedor acreedor) {
		return acreedorService.insertarAcreedor(acreedor);
	}
}


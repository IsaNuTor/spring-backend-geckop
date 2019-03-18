package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}


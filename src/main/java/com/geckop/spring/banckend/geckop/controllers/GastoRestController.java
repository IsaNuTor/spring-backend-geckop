package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;
import com.geckop.spring.banckend.geckop.models.services.IGastoService;

@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
@RestController
@RequestMapping("/api")
public class GastoRestController {
	@Autowired
	private IGastoService gastoService;
	
	@GetMapping("/gastos")
	public List<Gasto> index() {
		return gastoService.findAll();
	}
	
	@GetMapping("/gastos/{id}")
	public Gasto show(@PathVariable Long id) {
		return gastoService.buscarGastoPorId(id);
	}
	
	// Retorna el gasto que se creó en la base de datos.
	// Como viene en formato json desde Angular, indicamos
	// al parámetro de entrada que es un @RequestBody
	@PostMapping("/gastos")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto crearGasto(@RequestBody Gasto gasto) {
		return gastoService.insertarGasto(gasto);
	}
	
	// borrar, y le pasamos el id del gasto que queremos eliminar.
	@DeleteMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarGasto(@PathVariable Long id) {
		gastoService.eliminarGasto(id);
	}
}

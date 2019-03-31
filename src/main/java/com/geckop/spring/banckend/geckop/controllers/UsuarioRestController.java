package com.geckop.spring.banckend.geckop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.geckop.spring.banckend.geckop.models.entity.Usuario;
import com.geckop.spring.banckend.geckop.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	
	/*Va a retornar la lista de usuarios en json*/
	@GetMapping("/usuario")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}
	
    @GetMapping(path = {"/{id}"})
    public Boolean findOne(@PathVariable("id") String id){
        if( usuarioService.findById(id) != null)
        	return true;
        else 
        	return false;
    }	
    
    
    /*Devuelve el usuario logueado o null si no ha podido crearlo*/
   @PostMapping(path="/usuario")
    public Usuario login( @RequestBody Usuario usuario) {
	   Usuario user  = usuarioService.findById(usuario.getDni());
	   if(usuario.getPassword().equals( user.getPassword() ) )
    	return usuario;
	   else
		 return null;
    }
   
   //@PostMapping(path="/usuario")
   public Boolean findById( @RequestBody Usuario usuario) {
	   Usuario user  = usuarioService.findById(usuario.getDni());
	   if(usuario.getPassword().equals( user.getPassword() ) )
   	return true;
	   else
		 return false;
   }
   
   
   
   /*Devuelve el usuario creado o null si no ha podido crearlo*/
  // @PutMapping(path="/usuario")
   public Usuario registro(@RequestBody Usuario usuario) {
	   
	   if( usuarioService.findById(usuario.getDni()) == null) 
		   if (usuarioService.insert(usuario) != null)
			   return usuario;
		   
	   return null;
   }	   
		  
}

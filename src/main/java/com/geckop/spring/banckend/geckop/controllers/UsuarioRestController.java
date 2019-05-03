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

@CrossOrigin(origins= {"http://localhost:4200", "https://geckop.firebaseapp.com"})
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
   @PostMapping(path="/login")
    public Usuario login( @RequestBody Usuario usuario) {
	   Usuario user  = usuarioService.findById(usuario.getDni());
	   if(usuario.getPassword().equals( user.getPassword() ) )
    	return user;
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
   
   
   
   /*@PutMapping("/usuario/{nif}")
   @ResponseStatus(HttpStatus.CREATED)
   public Usuario actualizarEmail(@RequestBody String email, @PathVariable String nif  ) {
 	  if(usuarioService.findById(nif) != null) {
 		  usuarioService.
 	  }
 	  
	   
	   return user;
   }
   */
   
   /*Devuelve el usuario creado o null si no ha podido crearlo*/
  @PostMapping(path="/registro")
   public Usuario registro(@RequestBody Usuario usuario) {
	   
	   if( usuarioService.findById(usuario.getDni()) == null) 
		   if (usuarioService.insert(usuario) != null)
			   return usuario;
		   
	   return null;
   }
  
  @PostMapping(path="/comprobarPass")
  public Boolean comprobarContrasena(@RequestBody String[] variables) {
	   String dni = variables[0];
	   String pass = variables[1];
	   Usuario user = usuarioService.findById(dni);
	   if( user != null)
		   if (user.getPassword() == pass)
			   return true;
		   
	   return false;
  }
  
  @PostMapping(path="/setPass")
  public Boolean setContrasena(@RequestBody String[] variables) {
	   String dni = variables[0];
	   String pass = variables[1];
	   Usuario user = usuarioService.findById(dni);
	   if( user != null) {
		 user.setPassword(pass);
	     return true;
	   }
		   
	   return false;
  }
  
  @PostMapping(path="/setEmail")
  public Boolean setEmail(@RequestBody String[] variables) {
	   String dni = variables[0];
	   String email = variables[1];
	   Usuario user = usuarioService.findById(dni);
	   if( user != null) {
		 user.setEmail(email);
	     return true;
	   }
		   
	   return false;
  }
  

  
		  
}

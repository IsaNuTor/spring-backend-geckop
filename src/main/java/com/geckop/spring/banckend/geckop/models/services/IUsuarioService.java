package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Usuario;

public interface IUsuarioService {

	
	/*Elegimos los metodos que hay que implementar*/
	List<Usuario> findAll();

	Usuario findById(String id);
	Usuario insert(Usuario usuario);
	
}

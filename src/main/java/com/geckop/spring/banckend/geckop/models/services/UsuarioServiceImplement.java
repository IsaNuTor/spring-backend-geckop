package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.geckop.spring.banckend.geckop.models.dao.IUsuarioDao;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;

public class UsuarioServiceImplement implements IUsuarioService {
	 /*Implementamos los metodos que establezcamos en la interfaz*/
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	public List<Usuario> findAll(){
		 return (List<Usuario>) usuarioDao.findAll();
	}

	public Usuario findById(String id) {
		return usuarioDao.findOne(id);
		
	}
}

package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IUsuarioDao;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
	 /*Implementamos los metodos que establezcamos en la interfaz*/
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	public List<Usuario> findAll(){
		 return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(String id) {
		return usuarioDao.findOne(id);
		
	}
	
	@Override
	@Transactional
	public Usuario insert(Usuario user) {
		// TODO Auto-generated method stub
		return usuarioDao.save(user);
	}
}

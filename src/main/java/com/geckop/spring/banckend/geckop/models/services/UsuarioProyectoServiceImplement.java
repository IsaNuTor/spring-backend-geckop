package com.geckop.spring.banckend.geckop.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geckop.spring.banckend.geckop.models.dao.IUsuarioProyectoDao;
import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

@Service
public class UsuarioProyectoServiceImplement implements IUsuarioProyectoService {
	
	@Autowired
	private IUsuarioProyectoDao usuarioProyectoDao;

	@Override
	public UsuarioProyecto insertarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		return usuarioProyectoDao.save(usuarioProyecto);
	}
}

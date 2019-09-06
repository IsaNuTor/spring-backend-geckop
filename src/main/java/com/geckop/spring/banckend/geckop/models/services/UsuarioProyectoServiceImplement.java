package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.geckop.spring.banckend.geckop.models.dao.IUsuarioProyectoDao;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;
import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

@Service
public class UsuarioProyectoServiceImplement implements IUsuarioProyectoService {
	
	@Autowired
	private IUsuarioProyectoDao usuarioProyectoDao;

	@Override
	public UsuarioProyecto insertarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		return usuarioProyectoDao.save(usuarioProyecto);
	}

	@Override
	public List<UsuarioProyecto> findByProyect(String p) {
		 return (List<UsuarioProyecto>) usuarioProyectoDao.findByProyect(p);
	}

	@Override
	public List<UsuarioProyecto> findAll() {
		// TODO Auto-generated method stub
		return (List<UsuarioProyecto>) usuarioProyectoDao.findAll();
	}
	
	// Orden
	@Override
	public List<UsuarioProyecto> findBydni(String p) {
		// TODO Auto-generated method stub
		return (List<UsuarioProyecto>) usuarioProyectoDao.findByDni(p);
	}

	@Override
	public void eliminarUsuarioProyecto(UsuarioProyecto u) {
		usuarioProyectoDao.delete(u);
	}

	/*@Override
	public String selectUsuarioProyecto(String dni, String ac) {
		return usuarioProyectoDao.selectUsuarioProyecto(dni, ac);
	}*/

	
}

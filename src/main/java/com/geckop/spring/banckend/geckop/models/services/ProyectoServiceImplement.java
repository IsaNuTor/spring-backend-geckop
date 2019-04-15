package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geckop.spring.banckend.geckop.models.dao.IProyectoDao;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;

@Service
public class ProyectoServiceImplement implements IProyectoService {
	@Autowired
	private IProyectoDao proyectoDao;

	@Override
	public Proyecto insertarProyecto(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	public List<Proyecto> findAll() {
		return (List<Proyecto>) proyectoDao.findAll();
	}

}

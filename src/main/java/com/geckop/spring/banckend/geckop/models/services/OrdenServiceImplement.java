package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IOrdenDao;
import com.geckop.spring.banckend.geckop.models.entity.Orden;

@Service
public class OrdenServiceImplement implements IOrdenService{

	@Autowired
	private IOrdenDao ordenDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return (List<Orden>) ordenDao.findAll();
	}

	@Override
	public Orden buscarOrdenPorId(String acronimo, Long numeracion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden insertarOrden(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarOrden(String acronimo, Long numeracion) {
		// TODO Auto-generated method stub
		
	}

}

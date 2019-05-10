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
	@Transactional(readOnly=true)
	public Orden buscarOrdenPorAcryNum(String acronimo, Long numeracion) {
		// TODO Auto-generated method stub
		return ordenDao.findByAcryNum(acronimo, numeracion);
	}

	@Override
	@Transactional
	public Orden insertarOrden(Orden orden) {
		// TODO Auto-generated method stub
		String id_orden=orden.getAcronimo()+orden.getNumeracion().toString();
		System.out.println(id_orden);
		orden.setAcron_id(id_orden);
		//orden.setAcron_id("proyecto");
		return ordenDao.save(orden);
	}

	@Override
	@Transactional
	public void eliminarOrden(String acron_id) {
		ordenDao.delete(acron_id);	
	}
}

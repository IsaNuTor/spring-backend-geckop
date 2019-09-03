package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IGastoDao;
import com.geckop.spring.banckend.geckop.models.entity.Gasto;

@Service
public class GastoServiceImplement implements IGastoService{

	@Autowired
	private IGastoDao gastoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Gasto> findAll() {
		// TODO Auto-generated method stub
		return (List<Gasto>) gastoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Gasto buscarGastoPorId(Long id) {
		// TODO Auto-generated method stub
		return gastoDao.findOne(id);
	}

	@Override
	@Transactional
	public Gasto insertarGasto(Gasto gasto) {
		// TODO Auto-generated method stub
		return gastoDao.save(gasto);
	}

	@Override
	@Transactional
	public void eliminarGasto(Long id) {
		gastoDao.delete(id);
	}

	@Override
	public Boolean update(Gasto gasto) {
		// TODO Auto-generated method stub
		return gastoDao.save(gasto) != null;
	}

	@Override
	public List<Gasto> findByIdOrden(Long id_o) {
		// TODO Auto-generated method stub
		return gastoDao.findByIdOrden(id_o);
	}
}

package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IAcreedorDao;
import com.geckop.spring.banckend.geckop.models.entity.Acreedor;

@Service
public class AcreedorServiceImplement implements IAcreedorService{

	@Autowired
	private IAcreedorDao acreedorDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Acreedor> findAll() {
		// TODO Auto-generated method stub
		return (List<Acreedor>) acreedorDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Acreedor buscarAcreedorPorId(String id) {
		// TODO Auto-generated method stub
		return acreedorDao.findOne(id);
	}
	
	@Override
	@Transactional
	public Acreedor insertarAcreedor(Acreedor acreedor) {
		// TODO Auto-generated method stub
		return acreedorDao.save(acreedor);
	}
	
	/*
	@Override
	@Transactional
	public void eliminarAcreedor(String id) {
		// TODO Auto-generated method stub
		return acreedorDao.delete(id);
	}*/

}

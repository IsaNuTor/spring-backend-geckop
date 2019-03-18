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

}
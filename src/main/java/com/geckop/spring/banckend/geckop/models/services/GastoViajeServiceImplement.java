package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IGastoViajeDao;
import com.geckop.spring.banckend.geckop.models.entity.GastoViaje;

@Service
public class GastoViajeServiceImplement implements IGastoViajeService{
	
	@Autowired
	private IGastoViajeDao gastoViajeDao;

	@Override
	@Transactional(readOnly=true)
	public List<GastoViaje> findAll() {
		// TODO Auto-generated method stub
		return (List<GastoViaje>) gastoViajeDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public GastoViaje buscarGastoViajePorId(Long id) {
		// TODO Auto-generated method stub
		return gastoViajeDao.findOne(id);
	}

	@Override
	public GastoViaje insertarGastoViaje(GastoViaje gastoViaje) {
		// TODO Auto-generated method stub
		return gastoViajeDao.save(gastoViaje);
	}

	@Override
	public void eliminarGastoViaje(Long id) {
		gastoViajeDao.delete(id);
		
	}

	@Override
	public Boolean update(GastoViaje gastoViaje) {
		// TODO Auto-generated method stub
		return gastoViajeDao.save(gastoViaje) != null;
	}
}

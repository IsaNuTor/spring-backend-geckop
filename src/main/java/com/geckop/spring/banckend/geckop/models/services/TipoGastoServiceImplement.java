package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geckop.spring.banckend.geckop.models.dao.ITipoGastoDao;
import com.geckop.spring.banckend.geckop.models.entity.TipoGasto;

@Service
public class TipoGastoServiceImplement implements ITipoGastoService{

	@Autowired
	private ITipoGastoDao tipoGastoDao;
	@Override
	public List<TipoGasto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoGasto buscarTipoGastoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoGasto insertarTipoGasto(TipoGasto tipoGasto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarTipoGasto(Long id) {
		// TODO Auto-generated method stub
		
	}

}

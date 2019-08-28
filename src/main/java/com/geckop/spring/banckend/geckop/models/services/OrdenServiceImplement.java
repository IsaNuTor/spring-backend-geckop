package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Orden> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ordenDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Orden buscarOrdenPorId(Long id) {
		// TODO Auto-generated method stub
		return ordenDao.findOne(id);
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
		//orden.setAcron_id("proyecto");
		return ordenDao.save(orden);
	}

	@Override
	@Transactional
	public void eliminarOrden(Long id) {
		ordenDao.delete(id);	
	}

	@Override
	public List<Orden> findByNif(String n) {
		// TODO Auto-generated method stub
		return (List<Orden>) ordenDao.findByNif(n);
	}

	@Override
	public Long buscarNumeracionSiguiente(String a) {
		// TODO Auto-generated method stub
		return (Long) ordenDao.findNumeracionSiguiente(a);
	}
	public List<Orden> getOrdenesPendientesDeFirmaDeIP(String ip) {
		return (List<Orden>) ordenDao.getOrdenesPendientesDeFirmaDeIP(ip);

	}
}

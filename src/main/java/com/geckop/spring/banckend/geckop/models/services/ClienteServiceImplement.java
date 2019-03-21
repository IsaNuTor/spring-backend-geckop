package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geckop.spring.banckend.geckop.models.dao.IClienteDao;
import com.geckop.spring.banckend.geckop.models.entity.Cliente;

@Service
public class ClienteServiceImplement implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
	
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente buscarClientePorId(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findOne(id);
	}

	@Override
	@Transactional
	public Cliente insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void eliminarCliente(Long id) {
		// TODO Auto-generated method stub
		clienteDao.delete(id);
	}
}

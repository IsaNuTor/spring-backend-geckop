package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import com.geckop.spring.banckend.geckop.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
}

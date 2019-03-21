package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.nombre like %?1%")
	public List<Cliente> findByNombre(String term);

}

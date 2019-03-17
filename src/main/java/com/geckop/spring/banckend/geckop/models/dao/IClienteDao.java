package com.geckop.spring.banckend.geckop.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.geckop.spring.banckend.geckop.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}

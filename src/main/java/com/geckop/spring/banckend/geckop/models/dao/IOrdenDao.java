package com.geckop.spring.banckend.geckop.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.Orden;

public interface IOrdenDao extends CrudRepository<Orden, Long>{

}

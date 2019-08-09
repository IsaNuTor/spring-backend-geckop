package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;


public interface IUsuarioProyectoDao extends CrudRepository<UsuarioProyecto, String>{
	
	@Query(value = "SELECT * FROM UsuarioProyecto WHERE acronimo LIKE :p", nativeQuery=true)
	public List<UsuarioProyecto> findByProyect(@Param(value = "p") String p);


}

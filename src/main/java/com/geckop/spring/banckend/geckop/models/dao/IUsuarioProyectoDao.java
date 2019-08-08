package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

public interface IUsuarioProyectoDao extends CrudRepository<UsuarioProyecto, String>{
	

	@Query("select u from UsuarioProyecto u where u.acronimo = ?1")
	public List<UsuarioProyecto> findByProyect(String p);


}

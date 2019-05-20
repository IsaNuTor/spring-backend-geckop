package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.Cliente;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;
import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

public interface IProyectoDao extends CrudRepository<Proyecto, String>{
	
	//SELECT * FROM db_geckop_backend.usuarioproyecto where acronimo="AT";
	/*@Query("select u from usuarioproyecto u where acronimo=?1")
	public List<UsuarioProyecto> listaInvestigadoresProyecto(String acronimo);*/
	
	/*@Query("select u from UsuarioProyecto u")
	public List<UsuarioProyecto> listaInvestigadoresProyecto(String acronimo);*/
	
	/*@Query("select i from UsuarioProyecto i where i.acronimo=?1")
	public List<UsuarioProyecto> listaInvestigadoresProyecto(String acronimo);*/
}

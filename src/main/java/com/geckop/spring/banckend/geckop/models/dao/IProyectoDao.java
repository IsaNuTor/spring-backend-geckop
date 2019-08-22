package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;

public interface IProyectoDao extends CrudRepository<Proyecto, String>{

	
	//SELECT * FROM db_geckop_backend.usuarioproyecto where acronimo="AT";
	@Query(value ="SELECT * FROM proyecto as p where p.acronimo in (select u.acronimo from usuarioproyecto as u where u.dni= :d )", nativeQuery=true)
	public List<Proyecto> getProyectosUsuario(@Param(value = "d")String dni);
	
	/*@Query("select u from UsuarioProyecto u")
	public List<UsuarioProyecto> listaInvestigadoresProyecto(String acronimo);*/
	
	/*@Query("select i from UsuarioProyecto i where i.acronimo=?1")
	public List<UsuarioProyecto> listaInvestigadoresProyecto(String acronimo);*/
}

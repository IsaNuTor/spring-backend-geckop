package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geckop.spring.banckend.geckop.models.entity.Orden;
import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

public interface IOrdenDao extends CrudRepository<Orden, Long>{

	@Query("select o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acronimo, Long numeracion);
	
	/*@Query("insert o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acron_id);*/

}

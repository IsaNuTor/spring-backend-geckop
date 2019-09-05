package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geckop.spring.banckend.geckop.models.entity.Gasto;

public interface IGastoDao extends CrudRepository<Gasto, Long>{

	// Seleccionar los gastos de una orden
	@Query(value = "SELECT * FROM Gasto WHERE id_orden LIKE :id_o", nativeQuery=true)
	public List<Gasto> findByIdOrden(@Param(value = "id_o") Long id_o);
}

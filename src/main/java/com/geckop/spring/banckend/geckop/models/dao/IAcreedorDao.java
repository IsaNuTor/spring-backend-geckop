package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geckop.spring.banckend.geckop.models.entity.Acreedor;

public interface IAcreedorDao extends CrudRepository<Acreedor, String>{

	@Query(value = "SELECT * FROM Acreedor WHERE nif NOT IN (SELECT dni FROM Usuario WHERE dni != :dni)", nativeQuery=true)
	List<Acreedor> acreedoresOrden(@Param(value = "dni") String dni);

}

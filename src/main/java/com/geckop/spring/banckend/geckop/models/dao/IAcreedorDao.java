package com.geckop.spring.banckend.geckop.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.Acreedor;

public interface IAcreedorDao extends CrudRepository<Acreedor, String>{
	
	@Query("delete from Acreedor a where a.nif = nif")
	public Acreedor borrarPorNif(String nif);

}

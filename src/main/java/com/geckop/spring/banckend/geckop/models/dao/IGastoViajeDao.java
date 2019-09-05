package com.geckop.spring.banckend.geckop.models.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.geckop.spring.banckend.geckop.models.entity.GastoViaje;

public interface IGastoViajeDao extends CrudRepository<GastoViaje, Long>{
	// Seleccionar las ordenes que realizamos.
	@Query(value = "SELECT * FROM GastoViaje WHERE id_orden LIKE :id_o", nativeQuery=true)
	public GastoViaje findByIdOrden(@Param(value = "id_o") Long id_o);

}

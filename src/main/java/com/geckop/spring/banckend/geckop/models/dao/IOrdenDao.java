package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.geckop.spring.banckend.geckop.models.entity.Orden;

public interface IOrdenDao extends CrudRepository<Orden, Long>{

	@Query("select o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acronimo, Long numeracion);
	
	/*@Query("insert o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acron_id);*/
	
	// Seleccionar las ordenes que realizamos.
	@Query(value = "SELECT * FROM Orden WHERE nif_user LIKE :n", nativeQuery=true)
	public List<Orden> findByNif(@Param(value = "n") String n);

	// Seleccionar la numeracion siguiente respecto al proyecto.
	@Query(value = "SELECT MAX(numeracion)+1 FROM Orden WHERE acronimo LIKE :a", nativeQuery=true)
	public Long findNumeracionSiguiente(@Param(value = "a") String a);

	@Query(value = "SELECT * FROM Orden WHERE estado = 'P' AND acronimo IN (SELECT acronimo FROM proyecto WHERE proyecto.ip1 = :ip OR proyecto.ip2 = :ip)", nativeQuery=true)
	public List<Orden> getOrdenesPendientesDeFirmaDeIP(@Param(value = "ip") String ip);

	// Seleccionar las ordenes por proyecto.
	@Query(value = "SELECT * FROM Orden WHERE acronimo LIKE :a", nativeQuery=true)
	public List<Orden> findByProyect(@Param(value = "a")String id);
	
	

}


package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.geckop.spring.banckend.geckop.models.entity.Orden;

public interface IOrdenDao extends JpaRepository<Orden, Long>{

	@Query("select o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acronimo, Long numeracion);
	
	/*@Query("insert o from Orden o where o.acronimo=?1 and o.numeracion=?2")
	public Orden findByAcryNum(String acron_id);*/
	
	// Seleccionar las ordenes que realizamos.
	@Query(value = "SELECT * FROM Orden WHERE nif_user LIKE :n", nativeQuery=true)
	public List<Orden> findByNif(@Param(value = "n") String n);

	@Query(value = "SELECT * FROM Orden WHERE estado = 'P' AND acronimo IN (SELECT acronimo FROM proyecto WHERE proyecto.ip1 = :ip OR proyecto.ip2 = :ip)", nativeQuery=true)
	public List<Orden> getOrdenesPendientesDeFirmaDeIP(@Param(value = "ip") String ip);
}



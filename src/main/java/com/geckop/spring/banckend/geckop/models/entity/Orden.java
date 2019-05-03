package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {

	@Id
	private Long id;
	
	private Long numeracion;
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(Long numeracion) {
		this.numeracion = numeracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

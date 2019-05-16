package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orden")
public class Orden implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// Datos del ip y el acronimo lo sacamos del proyecto
	private String acronimo;
	private Long numeracion;
	private String estado;
	private String nif_user;

	@NotNull(message = "No puede estar vacio")
	@Column(name = "fecha_orden")
	private Date fechaOrden;
	private String num_contabilidad;
	private String concepto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif_user() {
		return nif_user;
	}

	public void setNif_user(String nif_user) {
		this.nif_user = nif_user;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	// Memoria explicativa de los gastos
	private String memoria;

	// Relacion con el proyecto
	private String relacion;

	// Pagar a, necestitamos los datos del acreedor
	private String nif_acreedor;


	@NotNull(message = "No puede estar vacio")
	private String observaciones;

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public String getNum_contabilidad() {
		return num_contabilidad;
	}

	public void setNum_contabilidad(String num_contabilidad) {
		this.num_contabilidad = num_contabilidad;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getNif_acreedor() {
		return nif_acreedor;
	}

	public void setNif_acreedor(String nif_acreedor) {
		this.nif_acreedor = nif_acreedor;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

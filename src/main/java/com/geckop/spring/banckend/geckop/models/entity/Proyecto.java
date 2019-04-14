package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {

	@Id
	private String acronimo;

	private String nombre;
	private double presupuesto;
	private int nContabilidad;

	@Column(name="ip1")
	private String ip1;
	
	@Column(name="ip2")
	private String ip2;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="fecha_cierre")
	private Date fechaCierre;

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getnContabilidad() {
		return nContabilidad;
	}

	public void setnContabilidad(int nContabilidad) {
		this.nContabilidad = nContabilidad;
	}

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getDniIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

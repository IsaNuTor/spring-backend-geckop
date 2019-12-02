package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;
import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String tipo;
	private String nif_IP;
	private String iban;
	private String observaciones_IP;
	

	//@NotNull(message = "No puede estar vacio")
	@Column(name = "fecha_orden")
	private Date fechaOrden;
	
	private String num_contabilidad;
	private String concepto;
	
	// Memoria explicativa de los gastos
	private String memoria;

	// Relacion con el proyecto
	private String relacion;

	// Pagar a, necestitamos los datos del acreedor
	private String nif_acreedor;

	//@NotNull(message = "No puede estar vacio")
	private String observaciones;
	private String tipo_gasto;
	
	// Cascade sirve para en el caso de que se elimine una orden, elimine los gastos asociados a esa orden.
	/*@JsonIgnoreProperties({"orden", "hibernateLazyInitializer", "handler"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="orden", cascade=CascadeType.ALL)
	private List<Gasto> gastos;*/
	
	// Constructor
	public Orden() {
		//this.gastos = new ArrayList<>();
	}

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
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNif_IP() {
		return nif_IP;
	}

	public void setNif_IP(String nif_IP) {
		this.nif_IP = nif_IP;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getObservaciones_IP() {
		return observaciones_IP;
	}

	public void setObservaciones_IP(String observaciones_IP) {
		this.observaciones_IP = observaciones_IP;
	}

	public String getTipo_gasto() {
		return tipo_gasto;
	}

	public void setTipo_gasto(String tipo_gasto) {
		this.tipo_gasto = tipo_gasto;
	}

	private static final long serialVersionUID = 1L;
}

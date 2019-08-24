package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gasto")
public class Gasto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	/*//@JoinColumn(name="orden_id") Por defecto será esta, no hace falta ponerla
	@JsonIgnoreProperties({"gastos", "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.LAZY)
	private Orden orden;*/
	
	private Long id_orden; 
	private String nfactura;
	private double importe;
	private String descripcion;
	private double iva;
	
	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	public Long getId_orden() {
		return id_orden;
	}

	public void setId_orden(Long id_orden) {
		this.id_orden = id_orden;
	}
	
	public String getnFactura() {
		return nfactura;
	}

	public void setnFactura(String nFactura) {
		this.nfactura = nFactura;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

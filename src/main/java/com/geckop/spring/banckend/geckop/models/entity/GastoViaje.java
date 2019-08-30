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
@Table(name = "gastoviaje")
public class GastoViaje implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="fecha_ida")
	private Date fechaIda;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="fecha_vuelta")
	private Date fechaVuelta;
	
	private Long id_orden;
	
	// Transporte.
	/*Avión*/
	private String avion;
	@Column(name="importe_avion")
	private double importeAvion;
	
	@Column(name="foto_avion")
	private String fotoAvion;
	
	/*Coche*/
	private String coche;
	
	private double nkilometros;
	@Column(name="precio_kilometro")
	private double precioKilometro;
	
	@Column(name="importe_coche")
	private double importeCoche;
	
	@Column(name="foto_coche")
	private String fotoCoche;
	
	/*Tren*/
	private String tren;
	@Column(name="importe_tren")
	private double importeTren;
	
	@Column(name="foto_tren")
	private String fotoTren;
	
	/*Autobus*/
	private String autobus;
	@Column(name="importe_autobus")
	private double importeAutobus;
	
	@Column(name="foto_autobus")
	private String fotoAutobus;
	
	/*Taxi*/
	private String taxi;
	@Column(name="importe_taxi")
	private double importeTaxi;
	
	@Column(name="foto_taxi")
	private String fotoTaxi;
	
	/*Otros*/
	private String otros;
	
	@Column(name="importe_otros")
	private double importeOtros;
	
	@Column(name="foto_otros")
	private String fotoOtros;
	
	/*Hotel*/
	@Column(name="n_fac_hotel")
	private String nFacturaHotel;
	
	@Column(name="importe_hotel")
	private double importeHotel;
	
	@Column(name="foto_hotel")
	private String fotoHotel;
	
	/*Manutención*/
	@Column(name="n_dietas")
	private int nDietas;
	
	@Column(name="precio_dieta")
	private double precioDieta;
	
	@Column(name="importe_dietas")
	private double importeDietas;
	
	/*Otros gastos*/
	@Column(name="otros_gastos")
	private String otrosGastos;
	
	@Column(name="importe_otros_gastos")
	private double importeOtrosGastos;
	
	/*Importe total, la suma de todos los importes anteriores*/
	@Column(name="importe_total")
	private double importeTotal;
	
	/* Getters y Setters */
	
	/**
	 * 
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public Long getId_orden() {
		return id_orden;
	}

	public void setId_orden(Long id_orden) {
		this.id_orden = id_orden;
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
		this.avion = avion;
	}

	public double getImporteAvion() {
		return importeAvion;
	}

	public void setImporteAvion(double importeAvion) {
		this.importeAvion = importeAvion;
	}

	public String getFotoAvion() {
		return fotoAvion;
	}

	public void setFotoAvion(String fotoAvion) {
		this.fotoAvion = fotoAvion;
	}

	public String getCoche() {
		return coche;
	}

	public void setCoche(String coche) {
		this.coche = coche;
	}

	public double getNkilometros() {
		return nkilometros;
	}

	public void setNkilometros(double nkilometros) {
		this.nkilometros = nkilometros;
	}

	public double getPrecioKilometro() {
		return precioKilometro;
	}

	public void setPrecioKilometro(double precioKilometro) {
		this.precioKilometro = precioKilometro;
	}

	public double getImporteCoche() {
		return importeCoche;
	}

	public void setImporteCoche(double importeCoche) {
		this.importeCoche = importeCoche;
	}

	public String getFotoCoche() {
		return fotoCoche;
	}

	public void setFotoCoche(String fotoCoche) {
		this.fotoCoche = fotoCoche;
	}

	public String getTren() {
		return tren;
	}

	public void setTren(String tren) {
		this.tren = tren;
	}

	public double getImporteTren() {
		return importeTren;
	}

	public void setImporteTren(double importeTren) {
		this.importeTren = importeTren;
	}

	public String getFotoTren() {
		return fotoTren;
	}

	public void setFotoTren(String fotoTren) {
		this.fotoTren = fotoTren;
	}

	public String getAutobus() {
		return autobus;
	}

	public void setAutobus(String autobus) {
		this.autobus = autobus;
	}

	public double getImporteAutobus() {
		return importeAutobus;
	}

	public void setImporteAutobus(double importeAutobus) {
		this.importeAutobus = importeAutobus;
	}

	public String getFotoAutobus() {
		return fotoAutobus;
	}

	public void setFotoAutobus(String fotoAutobus) {
		this.fotoAutobus = fotoAutobus;
	}

	public String getTaxi() {
		return taxi;
	}

	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}

	public double getImporteTaxi() {
		return importeTaxi;
	}

	public void setImporteTaxi(double importeTaxi) {
		this.importeTaxi = importeTaxi;
	}

	public String getFotoTaxi() {
		return fotoTaxi;
	}

	public void setFotoTaxi(String fotoTaxi) {
		this.fotoTaxi = fotoTaxi;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public double getImporteOtros() {
		return importeOtros;
	}

	public void setImporteOtros(double importeOtros) {
		this.importeOtros = importeOtros;
	}

	public String getFotoOtros() {
		return fotoOtros;
	}

	public void setFotoOtros(String fotoOtros) {
		this.fotoOtros = fotoOtros;
	}

	public String getnFacturaHotel() {
		return nFacturaHotel;
	}

	public void setnFacturaHotel(String nFacturaHotel) {
		this.nFacturaHotel = nFacturaHotel;
	}

	public double getImporteHotel() {
		return importeHotel;
	}

	public void setImporteHotel(double importeHotel) {
		this.importeHotel = importeHotel;
	}

	public String getFotoHotel() {
		return fotoHotel;
	}

	public void setFotoHotel(String fotoHotel) {
		this.fotoHotel = fotoHotel;
	}

	public int getnDietas() {
		return nDietas;
	}

	public void setnDietas(int nDietas) {
		this.nDietas = nDietas;
	}

	public double getPrecioDieta() {
		return precioDieta;
	}

	public void setPrecioDieta(double precioDieta) {
		this.precioDieta = precioDieta;
	}

	public double getImporteDietas() {
		return importeDietas;
	}

	public void setImporteDietas(double importeDietas) {
		this.importeDietas = importeDietas;
	}

	public String getOtrosGastos() {
		return otrosGastos;
	}

	public void setOtrosGastos(String otrosGastos) {
		this.otrosGastos = otrosGastos;
	}

	public double getImporteOtrosGastos() {
		return importeOtrosGastos;
	}

	public void setImporteOtrosGastos(double importeOtrosGastos) {
		this.importeOtrosGastos = importeOtrosGastos;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

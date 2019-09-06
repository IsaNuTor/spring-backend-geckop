package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Vamos a establecer la entidad de los usuarios con los proyectos
 * En este caso la tabla consta de los distintos usuarios y al proyecto
 * al que pertenecen.
 * BBDD: Usuarios Proyecto (DNI (Usuario), Acrónimo (Proyecto), rol)
 * */

@Entity
@Table(name = "usuarioproyecto")
public class UsuarioProyecto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String acronimo;
	private String rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

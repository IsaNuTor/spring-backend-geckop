package com.geckop.spring.banckend.geckop.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Vamos a establecer la entidad de los usuarios con los proyectos
 * En este caso la tabla consta de los distintos usuarios y al proyecto
 * al que pertenecen.
 * BBDD: Usuarios Proyecto (DNI (Usuario), Acrónimo (Proyecto))
 * */

@Entity
@Table(name = "usuarioproyecto")
public class UsuarioProyecto implements Serializable {

	@Id
	private String dni;

	private String acronimo;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

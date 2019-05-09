/**
 * 
 */
package com.geckop.spring.banckend.geckop.models.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import org.springframework.data.repository.CrudRepository;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, String> {
    
	
	/*public static void update(Usuario user) {
		String UPDATE = "UPDATE users SET dni=?, password=?, apellido1=?, apellido2=?, email=?, telefono=?, departamento=?, centro=? WHERE dni=?";
	    Connection conn = null;
	    try {
	    	
	 
	            PreparedStatement ps = conn.prepareStatement(UPDATE);
	 
	            ps.setString(1, user.getDni());
	            ps.setString(2, user.getPassword());
	            ps.setString(3, user.getApellido1());
	            ps.setString(4, user.getApellido2());
	            ps.setString(5, user.getEmail());
	            ps.setString(6, user.getTelefono());
	            ps.setString(7, user.getDepartamento());
	            ps.setString(8, user.getCentro());
	            ps.setString(9, user.getDni());
	            ps.executeUpdate();
	            ps.close();
	 
	            System.out.println("User with id " + user.getDni() + " was updated in DB with following details: " + user.toString());
	 
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
	         
	}*/

}

/**
 * 
 */
package com.geckop.spring.banckend.geckop.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import org.springframework.data.repository.CrudRepository;

import com.geckop.spring.banckend.geckop.models.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, String> {
    
}

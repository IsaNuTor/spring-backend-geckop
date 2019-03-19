/**
 * 
 */
package com.geckop.spring.banckend.geckop.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.geckop.spring.banckend.geckop.models.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, String> {

}

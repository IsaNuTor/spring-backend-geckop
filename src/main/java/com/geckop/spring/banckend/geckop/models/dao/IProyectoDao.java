package com.geckop.spring.banckend.geckop.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;

public interface IProyectoDao extends CrudRepository<Proyecto, String>{
}

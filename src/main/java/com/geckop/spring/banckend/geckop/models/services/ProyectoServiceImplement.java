package com.geckop.spring.banckend.geckop.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geckop.spring.banckend.geckop.models.dao.IProyectoDao;
import com.geckop.spring.banckend.geckop.models.entity.Proyecto;
import com.geckop.spring.banckend.geckop.models.entity.UsuarioProyecto;

@Service
public class ProyectoServiceImplement implements IProyectoService {
	@Autowired
	private IProyectoDao proyectoDao;

	@Override
	public Proyecto insertarProyecto(Proyecto proyecto) {
		return proyectoDao.save(proyecto);
	}

	@Override
	public List<Proyecto> findAll() {
		return (List<Proyecto>) proyectoDao.findAll();
	}
	
	@Override
	public Proyecto buscarProyecto(String id) {
		return proyectoDao.findOne(id);
	}

	@Override
	public void borrarProyecto(String acronimo) {
		proyectoDao.delete(acronimo);
		
	}
	
	@Override
	public Proyecto updateProyecto(Proyecto p) {
		if(this.buscarProyecto(p.getAcronimo()) != null) {
			return proyectoDao.save(p);
		}else{
			return null;
		}
	}
	
	@Override
	public List<Proyecto> getProyectosUsuario(String dni) {
		// TODO Auto-generated method stub
		return proyectoDao.getProyectosUsuario(dni);
	}

	//@Override
	/*public UsuarioProyecto[] getInvestigadoresProyecto(String id) {
		// TODO Auto-generated method stub
		return proyectoDao.listaInvestigadoresProyecto(id);
	}*/

}

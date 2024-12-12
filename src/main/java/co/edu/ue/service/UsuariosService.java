package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuariosDao;
import co.edu.ue.entity.Usuarios;

@Service
public class UsuariosService implements IUsuariosService { 
	
      @Autowired
	  private IUsuariosDao dao;

	    @Override
	    public List<Usuarios> guardarUsuario(Usuarios usuario) {
	        return dao.guardarUsuarios(usuario);
	    }

	    @Override
	    public Usuarios actualizarUsuario(Usuarios usuario) {
	        return dao.actualizarUsuarios(usuario);
	    }

	    @Override
	    public boolean eliminarUsuario(int usuid) {
	        return dao.eliminarUsuarios(usuid);
	    }

	    @Override
	    public List<Usuarios> listaCompleta() {
	        return dao.listaCompleta();
	    }

	    @Override
	    public Usuarios busquedaPorId(int usuid) {
	        return dao.busquedaporId(usuid);
	    }

	    @Override
	    public Usuarios busquedaPorEmail(String usuEmail) {
	        return dao.busquedaporEmail(usuEmail);
	    }
	}

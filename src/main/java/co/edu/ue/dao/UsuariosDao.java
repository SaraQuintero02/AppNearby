package co.edu.ue.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Perfiles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.jpa.IUsuariosJpa;

//DAO OBJETO DE ACCESO A LOS DATOS POR MEDIO DEL JPA HACE CONEXION A LA DATABASE
// POLIMORFISMO //LA CLASE USUARION QUE ES LA IMPLEMENTACION DE LA
// INTERFAZ METODOS QUE LE DAN CUERPO A LA CAPA IUSUARIOSDAO

@Repository
public class UsuariosDao implements IUsuariosDao { 
	
	@Autowired
	private IUsuariosJpa jpa;

	@Override
	public List<Usuarios> guardarUsuarios(Usuarios usuario) {
		jpa.save(usuario);
		return listaCompleta();
	}

	@Override
	public Usuarios actualizarusuarios(Usuarios usuario) {
		return jpa.save(usuario);
	}

	@Override
	public boolean eliminarUsuarios(int usuid) {
		Usuarios usuario = busquedaporId(usuid);
		if (usuario != null) {
			jpa.delete(usuario);
			return true;
		}
		return false;
	}

	@Override
	public List<Usuarios> listaCompleta() {
		return jpa.findAll();
	}

	@Override
	public Usuarios busquedaporId(int usuId) {
		return jpa.findById(usuId).orElse(null);
	}

	@Override
	public Usuarios busquedaporEmail(String usuEmail) {
		return jpa.findByUsuEmail(usuEmail);
	}

	@Override
	public Usuarios actualizarUsuarios(Usuarios usuario) {
		return jpa.save(usuario);
	}

	@Override
	public Perfiles guardarPerfil(Perfiles perfil) {
		return null;
	}

}
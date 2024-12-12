package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IPerfilesDao;
import co.edu.ue.entity.Perfiles;

@Service
public class PerfilesService implements IPerfilesService {

	@Autowired
	private IPerfilesDao dao;

	@Override
	public Perfiles guardarPerfil(Perfiles perfil) {
		return dao.guardarPerfil(perfil);
	}

	@Override
	public Perfiles actualizarPerfil(Perfiles perfil) {
		return dao.actualizarPerfil(perfil);
	}

	@Override
	public boolean eliminarPerfil(int perId) {
		return dao.eliminarPerfil(perId);
	}

	@Override
	public List<Perfiles> listaCompleta() {
		return dao.listaCompleta();
	}

	@Override
	public Perfiles busquedaPorId(int perId) {
		return dao.busquedaPorId(perId);
	}

	@Override
	public List<Perfiles> busquedaPorUsuarioId(int usuarioId) {
		return dao.busquedaPorUsuarioId(usuarioId);
	}
}

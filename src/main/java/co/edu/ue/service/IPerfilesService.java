package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Perfiles;

public interface IPerfilesService {
	
	//METODO PARA CREAR EL CRUD
	Perfiles guardarPerfil(Perfiles perfil);
    Perfiles actualizarPerfil(Perfiles perfil);
    boolean eliminarPerfil(int perId);
    
    //CONSULTAS
    List<Perfiles> listaCompleta();
    Perfiles busquedaPorId(int perId);
    List<Perfiles> busquedaPorUsuarioId(int usuarioId);

}

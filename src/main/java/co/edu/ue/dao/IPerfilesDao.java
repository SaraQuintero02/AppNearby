package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Perfiles;

public interface IPerfilesDao {
	//METODOS CRUD
    Perfiles guardarPerfil(Perfiles perfil);
    Perfiles actualizarPerfil(Perfiles perfil);
    boolean eliminarPerfil(int perId);

    //CONSULTAS
    List<Perfiles> listaCompleta();
    Perfiles busquedaPorId(int perId);
    List<Perfiles> busquedaPorUsuarioId(int usuariousuId);

}

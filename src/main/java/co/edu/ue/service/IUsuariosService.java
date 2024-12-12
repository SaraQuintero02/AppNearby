package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuariosService {
		    List<Usuarios> guardarUsuario(Usuarios usuario);
		    
		    Usuarios actualizarUsuario(Usuarios usuario);
		    
		    boolean eliminarUsuario(int usuid);
		    
		    List<Usuarios> listaCompleta();
		    
		    Usuarios busquedaPorId(int usuid);
		    
		    Usuarios busquedaPorEmail(String usuEmail);

}

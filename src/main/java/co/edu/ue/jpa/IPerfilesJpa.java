package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Perfiles;

public interface IPerfilesJpa extends JpaRepository<Perfiles, Integer>{

	    List<Perfiles> findByUsuario_UsuId(int usuarioId);

}

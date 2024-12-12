package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Perfiles;
import co.edu.ue.jpa.IPerfilesJpa;

@Repository
public class PerfilesDao implements IPerfilesDao {

    @Autowired
    private IPerfilesJpa jpa;

    @Override
    public Perfiles guardarPerfil(Perfiles perfil) {
        return jpa.save(perfil);
    }

    @Override
    public Perfiles actualizarPerfil(Perfiles perfil) {
        return jpa.save(perfil);
    }

    @Override
    public boolean eliminarPerfil(int perId) {
        Perfiles perfil = busquedaPorId(perId);
        if (perfil != null) {
            jpa.delete(perfil);
            return true;
        }
        return false;
    }

    @Override
    public List<Perfiles> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public Perfiles busquedaPorId(int perId) {
        return jpa.findById(perId).orElse(null);
    }

    @Override
    public List<Perfiles> busquedaPorUsuarioId(int usuariousuId) {
        return jpa.findByUsuario_UsuId(usuariousuId);
    }
}

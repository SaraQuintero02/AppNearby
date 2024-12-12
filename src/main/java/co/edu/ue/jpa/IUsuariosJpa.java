package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Usuarios;

//LE DIGO QUE ME DE TODAS LAS FUNCIONALIDADES QUE TINE JPA CON EXTENDS HEREDO
//LE PONGO OBJETO INTEGER QUE ES INT
//EN JPA AGREGO METODOS QUE NO ME DE JPA
public interface IUsuariosJpa extends JpaRepository <Usuarios, Integer> {
    Usuarios findByUsuEmail(String usuEmail);
}
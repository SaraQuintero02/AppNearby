package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Perfiles;
import co.edu.ue.service.IPerfilesService;

@RestController
@RequestMapping("/perfiles")
public class PerfilesController {

    @Autowired//CABLEAMOS LA CAPA INTERFACE PERFILES SERVICE PARA OBTENER NUESTRO CRUD Y CONSULTAS
    private IPerfilesService service;

    
    //GUARDAR UN PERFIL
    @PostMapping
    public ResponseEntity<Perfiles> guardarPerfil(@RequestBody Perfiles perfil) {
        Perfiles nuevoPerfil = service.guardarPerfil(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPerfil);
    }

    //ACTUALIZAR UN PERFIL
    @PutMapping
    public ResponseEntity<Perfiles> actualizarPerfil(@RequestBody Perfiles perfil) {
        Perfiles perfilActualizado = service.actualizarPerfil(perfil);
        return ResponseEntity.ok(perfilActualizado);
    }
    
    //ELIMINAR UN PERFIL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable int id) {
        boolean eliminado = service.eliminarPerfil(id);
        return eliminado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    //OBTENER LOS PERFILES
    @GetMapping
    public ResponseEntity<List<Perfiles>> listaCompleta() {
        List<Perfiles> perfiles = service.listaCompleta();
        return ResponseEntity.ok(perfiles);
    }
    
    //CONSULTAR PERFIL POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Perfiles> busquedaPorId(@PathVariable int id) {
        Perfiles perfil = service.busquedaPorId(id);
        return perfil != null ? ResponseEntity.ok(perfil) : ResponseEntity.notFound().build();
    }
    
    //CONSULTA PERFIR POR USUARIOID
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Perfiles>> busquedaPorUsuarioId(@PathVariable int usuarioId) {
        List<Perfiles> perfiles = service.busquedaPorUsuarioId(usuarioId);
        return perfiles != null && !perfiles.isEmpty() ? ResponseEntity.ok(perfiles) : ResponseEntity.notFound().build();
    }
}


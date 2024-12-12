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
import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.IUsuariosService;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService servicio;

	// GUARDAR USUARIO
	@PostMapping
	public List<Usuarios> guardarUsuario(@RequestBody Usuarios usuario) {
		return servicio.guardarUsuario(usuario);
	}

	//ACTUALIZAR USUARIO
	@PutMapping
	public Usuarios actualizarUsuario(@RequestBody Usuarios usuario) {
		return servicio.actualizarUsuario(usuario);
	}

	// ELIMINAR USUARIO
	@DeleteMapping("/{id}")
	public boolean eliminarUsuario(@PathVariable int id) {
		return servicio.eliminarUsuario(id);
	}

	// MOSTRAR TODOS LOS USUARIOS
	@GetMapping
	public List<Usuarios> listaCompleta() {
		return servicio.listaCompleta();
	}

	// CONSULTAS
	
	//BUSCAR USUARIO POR ID
	@GetMapping("/{id}")
	public Usuarios busquedaPorId(@PathVariable int id) {
		return servicio.busquedaPorId(id);
	}

	// BUSCAR BUSCAR USUARIO POR CORREO
	@GetMapping("/email/{email}")
	public Usuarios busquedaPorEmail(@PathVariable String email) {
		return servicio.busquedaPorEmail(email);
	}
}

package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarios.findAll", query="SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private int usuId;

	@Column(name="usu_contraseña")
	private String usuContraseña;

	@Column(name="usu_edad")
	private int usuEdad;

	@Column(name="usu_email")
	private String usuEmail;

	@Column(name="usu_genero")
	private String usuGenero;

	@Column(name="usu_nombre")
	private String usuNombre;

	//bi-directional many-to-one association to Matches
	@OneToMany(mappedBy="usuario1")
	private List<Matches> matches1;

	//bi-directional many-to-one association to Matches
	@OneToMany(mappedBy="usuario2")
	private List<Matches> matches2;

	//bi-directional many-to-one association to Perfiles
	@OneToMany(mappedBy="usuario")
	private List<Perfiles> perfiles;

	public Usuarios() {
	}

	public int getUsuId() {
		return this.usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public String getUsuContraseña() {
		return this.usuContraseña;
	}

	public void setUsuContraseña(String usuContraseña) {
		this.usuContraseña = usuContraseña;
	}

	public int getUsuEdad() {
		return this.usuEdad;
	}

	public void setUsuEdad(int usuEdad) {
		this.usuEdad = usuEdad;
	}

	public String getUsuEmail() {
		return this.usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public String getUsuGenero() {
		return this.usuGenero;
	}

	public void setUsuGenero(String usuGenero) {
		this.usuGenero = usuGenero;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public List<Matches> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Matches> matches1) {
		this.matches1 = matches1;
	}

	public Matches addMatches1(Matches matches1) {
		getMatches1().add(matches1);
		matches1.setUsuario1(this);

		return matches1;
	}

	public Matches removeMatches1(Matches matches1) {
		getMatches1().remove(matches1);
		matches1.setUsuario1(null);

		return matches1;
	}

	public List<Matches> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Matches> matches2) {
		this.matches2 = matches2;
	}

	public Matches addMatches2(Matches matches2) {
		getMatches2().add(matches2);
		matches2.setUsuario2(this);

		return matches2;
	}

	public Matches removeMatches2(Matches matches2) {
		getMatches2().remove(matches2);
		matches2.setUsuario2(null);

		return matches2;
	}

	public List<Perfiles> getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(List<Perfiles> perfiles) {
		this.perfiles = perfiles;
	}

	public Perfiles addPerfile(Perfiles perfile) {
		getPerfiles().add(perfile);
		perfile.setUsuario(this);

		return perfile;
	}

	public Perfiles removePerfile(Perfiles perfile) {
		getPerfiles().remove(perfile);
		perfile.setUsuario(null);

		return perfile;
	}

}
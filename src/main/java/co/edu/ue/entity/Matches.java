package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@NamedQuery(name="Matches.findAll", query="SELECT m FROM Matches m")
public class Matches implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id")
	private int matId;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="mat_usu1")
	private Usuarios usuario1;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="mat_usu2")
	private Usuarios usuario2;

	//bi-directional many-to-one association to CategoriasMatch
	@ManyToOne
	@JoinColumn(name="categorias_match_cat_mat_id")
	private CategoriasMatch categoriasMatch;

	public Matches() {
	}

	public int getMatId() {
		return this.matId;
	}

	public void setMatId(int matId) {
		this.matId = matId;
	}

	public Usuarios getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuarios usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuarios getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuarios usuario2) {
		this.usuario2 = usuario2;
	}

	public CategoriasMatch getCategoriasMatch() {
		return this.categoriasMatch;
	}

	public void setCategoriasMatch(CategoriasMatch categoriasMatch) {
		this.categoriasMatch = categoriasMatch;
	}

}
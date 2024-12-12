package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorias_match database table.
 * 
 */
@Entity
@Table(name="categorias_match")
@NamedQuery(name="CategoriasMatch.findAll", query="SELECT c FROM CategoriasMatch c")
public class CategoriasMatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_mat_id")
	private int catMatId;

	@Column(name="cat_mat_amistad")
	private String catMatAmistad;

	@Column(name="cat_mat_casual")
	private String catMatCasual;

	@Column(name="cat_mat_diversion")
	private String catMatDiversion;

	@Column(name="cat_mat_romance")
	private String catMatRomance;

	//bi-directional many-to-one association to Citas
	@OneToMany(mappedBy="categoriasMatch")
	private List<Citas> citas;

	//bi-directional many-to-one association to Matches
	@OneToMany(mappedBy="categoriasMatch")
	private List<Matches> matches;

	public CategoriasMatch() {
	}

	public int getCatMatId() {
		return this.catMatId;
	}

	public void setCatMatId(int catMatId) {
		this.catMatId = catMatId;
	}

	public String getCatMatAmistad() {
		return this.catMatAmistad;
	}

	public void setCatMatAmistad(String catMatAmistad) {
		this.catMatAmistad = catMatAmistad;
	}

	public String getCatMatCasual() {
		return this.catMatCasual;
	}

	public void setCatMatCasual(String catMatCasual) {
		this.catMatCasual = catMatCasual;
	}

	public String getCatMatDiversion() {
		return this.catMatDiversion;
	}

	public void setCatMatDiversion(String catMatDiversion) {
		this.catMatDiversion = catMatDiversion;
	}

	public String getCatMatRomance() {
		return this.catMatRomance;
	}

	public void setCatMatRomance(String catMatRomance) {
		this.catMatRomance = catMatRomance;
	}

	public List<Citas> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}

	public Citas addCita(Citas cita) {
		getCitas().add(cita);
		cita.setCategoriasMatch(this);

		return cita;
	}

	public Citas removeCita(Citas cita) {
		getCitas().remove(cita);
		cita.setCategoriasMatch(null);

		return cita;
	}

	public List<Matches> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

	public Matches addMatch(Matches match) {
		getMatches().add(match);
		match.setCategoriasMatch(this);

		return match;
	}

	public Matches removeMatch(Matches match) {
		getMatches().remove(match);
		match.setCategoriasMatch(null);

		return match;
	}

}
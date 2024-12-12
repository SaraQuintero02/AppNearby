package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@NamedQuery(name="Citas.findAll", query="SELECT c FROM Citas c")
public class Citas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cit_id")
	private int citId;

	@Column(name="cit_estado")
	private String citEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="cit_fecha")
	private Date citFecha;

	@Column(name="cit_hora")
	private String citHora;

	@Column(name="cit_ubicacion")
	private String citUbicacion;

	@Column(name="matches_mat_id")
	private int matchesMatId;

	@Column(name="matches_mat_id1")
	private int matchesMatId1;

	//bi-directional many-to-one association to CategoriasMatch
	@ManyToOne
	@JoinColumn(name="categorias_match_cat_mat_id")
	private CategoriasMatch categoriasMatch;

	public Citas() {
	}

	public int getCitId() {
		return this.citId;
	}

	public void setCitId(int citId) {
		this.citId = citId;
	}

	public String getCitEstado() {
		return this.citEstado;
	}

	public void setCitEstado(String citEstado) {
		this.citEstado = citEstado;
	}

	public Date getCitFecha() {
		return this.citFecha;
	}

	public void setCitFecha(Date citFecha) {
		this.citFecha = citFecha;
	}

	public String getCitHora() {
		return this.citHora;
	}

	public void setCitHora(String citHora) {
		this.citHora = citHora;
	}

	public String getCitUbicacion() {
		return this.citUbicacion;
	}

	public void setCitUbicacion(String citUbicacion) {
		this.citUbicacion = citUbicacion;
	}

	public int getMatchesMatId() {
		return this.matchesMatId;
	}

	public void setMatchesMatId(int matchesMatId) {
		this.matchesMatId = matchesMatId;
	}

	public int getMatchesMatId1() {
		return this.matchesMatId1;
	}

	public void setMatchesMatId1(int matchesMatId1) {
		this.matchesMatId1 = matchesMatId1;
	}

	public CategoriasMatch getCategoriasMatch() {
		return this.categoriasMatch;
	}

	public void setCategoriasMatch(CategoriasMatch categoriasMatch) {
		this.categoriasMatch = categoriasMatch;
	}

}
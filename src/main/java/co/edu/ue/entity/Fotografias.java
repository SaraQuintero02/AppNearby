package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fotografias database table.
 * 
 */
@Entity
@NamedQuery(name="Fotografias.findAll", query="SELECT f FROM Fotografias f")
public class Fotografias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fot_id")
	private int fotId;

	@Temporal(TemporalType.DATE)
	private Date fot_fechaSubida;

	@Column(name="perfiles_per_id")
	private int perfilesPerId;

	//bi-directional many-to-one association to Perfiles
	@ManyToOne
	@JoinColumn(name="perfiles_per_id1")
	private Perfiles perfile;

	public Fotografias() {
	}

	public int getFotId() {
		return this.fotId;
	}

	public void setFotId(int fotId) {
		this.fotId = fotId;
	}

	public Date getFot_fechaSubida() {
		return this.fot_fechaSubida;
	}

	public void setFot_fechaSubida(Date fot_fechaSubida) {
		this.fot_fechaSubida = fot_fechaSubida;
	}

	public int getPerfilesPerId() {
		return this.perfilesPerId;
	}

	public void setPerfilesPerId(int perfilesPerId) {
		this.perfilesPerId = perfilesPerId;
	}

	public Perfiles getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfiles perfile) {
		this.perfile = perfile;
	}

}
package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@NamedQuery(name="Perfiles.findAll", query="SELECT p FROM Perfiles p")
public class Perfiles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")
	private int perId;

	@Lob
	@Column(name="per_descripcion")
	private String perDescripcion;

	@Column(name="per_nombre")
	private String perNombre;

	@Column(name="usuarios_usu_id")
	private int usuariosUsuId;

	//bi-directional many-to-one association to Fotografias
	@OneToMany(mappedBy="perfile")
	private List<Fotografias> fotografias;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="usuarios_usu_id1")
	private Usuarios usuario;

	public Perfiles() {
	}

	public int getPerId() {
		return this.perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPerDescripcion() {
		return this.perDescripcion;
	}

	public void setPerDescripcion(String perDescripcion) {
		this.perDescripcion = perDescripcion;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public int getUsuariosUsuId() {
		return this.usuariosUsuId;
	}

	public void setUsuariosUsuId(int usuariosUsuId) {
		this.usuariosUsuId = usuariosUsuId;
	}

	public List<Fotografias> getFotografias() {
		return this.fotografias;
	}

	public void setFotografias(List<Fotografias> fotografias) {
		this.fotografias = fotografias;
	}

	public Fotografias addFotografia(Fotografias fotografia) {
		getFotografias().add(fotografia);
		fotografia.setPerfile(this);

		return fotografia;
	}

	public Fotografias removeFotografia(Fotografias fotografia) {
		getFotografias().remove(fotografia);
		fotografia.setPerfile(null);

		return fotografia;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}
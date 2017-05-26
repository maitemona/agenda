package com.ipartek.formacion.persistencia;

import java.io.Serializable;
import java.util.List;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




import javax.persistence.Table;
import javax.persistence.Transient;
@Entity(name ="categoria")
@Table(name = "categoria")
@NamedQueries({
	@NamedQuery(name="categoria.getAll", query="SELECT cat FROM categoria cat")
})
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -6698866485450376235L;
	public static final int CODIGO_NULO = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria")
	private long idcategoria;
	@NotBlank
	@Column(name = "ncategoria")
	private String ncategoria;
	private boolean activo;
	
	/*@Fetch(FetchMode.JOIN)//para datos suceptibles de repeticion, o usamos Set, q es una coleccion q NO permite repetidos*/
	//@OneToMany(fetch = FetchType.EAGER)//carga del objeto
	//@OneToMany(fetch = FetchType.LAZY,mappedBy="categoria")
	@Transient
	private List<Contacto> contactos;

	
	
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public long getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(long idcategoria) {
		this.idcategoria = idcategoria;
	}
	
	
	public String getNcategoria() {
		return ncategoria;
	}
	public void setNcategoria(String ncategoria) {
		this.ncategoria = ncategoria;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idcategoria ^ (idcategoria >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (idcategoria != other.idcategoria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", ncategoria=" + ncategoria + "]";
	}
	
	
	
}

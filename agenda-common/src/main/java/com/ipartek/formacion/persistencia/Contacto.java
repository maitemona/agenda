package com.ipartek.formacion.persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Table(name = "contacto")
@Entity(name = "contacto")
@NamedQueries({
	@NamedQuery(name="contacto.getAll", query="SELECT cont FROM contacto cont where activo = 1")
})
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "contacto.getContactosporCategoria",procedureName="getContactosporCategoria", resultClasses = Contacto.class,
			parameters={@StoredProcedureParameter(mode = ParameterMode.IN, type= Long.class)} )
})
public class Contacto implements Serializable{
	private static final long serialVersionUID = -6698866485450376235L;
	public static final int CODIGO_NULO = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcontacto")
	private long idcontacto;
	@NotBlank
	private String cargo;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String ncontacto;
	@NotBlank
	private String poblacion;
	@NotBlank
	private String direccion;
	
	@Digits(integer=9,fraction=0)
	private int telefono;

	private boolean activo;
	
	@ManyToOne (fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="idcontactocategoria")
	private Categoria categoria = null;
	


	@Transient
	private List<Categoria> categorias;
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public Contacto() {
		// TODO Auto-generated constructor stub
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public long getIdcontacto() {
		return idcontacto;
	}


	public void setIdcontacto(long idcontacto) {
		this.idcontacto = idcontacto;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNcontacto() {
		return ncontacto;
	}


	public void setNcontacto(String ncontacto) {
		this.ncontacto = ncontacto;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idcontacto ^ (idcontacto >>> 32));
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
		Contacto other = (Contacto) obj;
		if (idcontacto != other.idcontacto)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Contacto [idcontacto=" + idcontacto + ", cargo=" + cargo + ", email=" + email + ", ncontacto="
				+ ncontacto + ", poblacion=" + poblacion + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", categoria=" + categoria + "]";
	}



	
		


	
	
}

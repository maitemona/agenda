package com.ipartek.formacion.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


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
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;

@Table
@Entity(name = "mailing")
@NamedQueries({
	@NamedQuery(name="mailing.getAll", query="SELECT m FROM mailing m")
})
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "mailing.getContactos",procedureName="contactogetByMailing", resultClasses = Contacto.class,
			parameters={@StoredProcedureParameter(mode = ParameterMode.IN, type= Long.class)} )
})
public class Mailing implements Serializable{ 

	private static final long serialVersionUID = -6698866485450376235L;
public static final int CODIGO_NULO = 0;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmailing")
	private long idmailing;
	@Future
	private Date fenvio;
	@NotBlank
	private String titulo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idnewslettermailing")
	private Newsletter newsletter = null;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idcategoria")
	private Categoria categoria = null;
	
	//**Para que me ignore este objeto y no me lo busque en la tabla (getALL)*/
	@Transient
	private List<Contacto> contactos;
	@Transient
	private List<Newsletter> newsletters;
	//**Para que me ignore este objeto y no me lo busque en la tabla (getALL)*/
	@Transient
	private List<Categoria> categorias;
	
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public List<Newsletter> getNewsletters() {
		return newsletters;
	}


	public void setNewsletters(List<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}


	public Mailing() {
		// TODO Auto-generated constructor stub
	}

	
	public List<Contacto> getContactos() {
		return contactos;
	}





	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}


	public long getIdmailing() {
		return idmailing;
	}

	public void setIdmailing(long idmailing) {
		this.idmailing = idmailing;
	}

	public Date getFenvio() {
		return fenvio;
	}

	public void setFenvio(Date fenvio) {
		this.fenvio = fenvio;
	}

	public Newsletter getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Newsletter newsletter) {
		this.newsletter = newsletter;
	}

	

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idmailing ^ (idmailing >>> 32));
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
		Mailing other = (Mailing) obj;
		if (idmailing != other.idmailing)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Mailing [idmailing=" + idmailing + ", fenvio=" + fenvio + ", titulo=" + titulo + ", newsletter="
				+ newsletter + ", categoria=" + categoria + ", categorias=" + categorias + "]";
	}






	
}

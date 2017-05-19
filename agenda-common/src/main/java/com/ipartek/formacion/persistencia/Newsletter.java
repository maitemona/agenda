package com.ipartek.formacion.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.NotBlank;
@Table(name = "newsletter")
@Entity(name = "newsletter")
@NamedQueries({
	@NamedQuery(name="newsletter.getAll", query="SELECT n FROM newsletter n where activo=1")
})
public class Newsletter implements Serializable{ 

	private static final long serialVersionUID = -6698866485450376235L;
	public static final int CODIGO_NULO = 0;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnewsletter")
	private long idnewsletter;
	
	private Date fcreacion;
	@NotBlank
	private String titulo;
	@NotBlank
	private String body;
	private boolean activo;
	private String archivo;
	
/*	@OneToMany(fetch = FetchType.LAZY,mappedBy="newsletter")*/
	@Transient
	private Set<Mailing> mailings;
	
	public Newsletter(){
		// TODO Auto-generated constructor stub
	}

	
	@Transient
	public Set<Mailing> getMailings() {
		return mailings;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public void setMailings(Set<Mailing> mailings) {
		this.mailings = mailings;
	}



	public String getArchivo() {
		return archivo;
	}


	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	public long getIdnewsletter() {
		return idnewsletter;
	}

	public void setIdnewsletter(long idnewsletter) {
		this.idnewsletter = idnewsletter;
	}

	public Date getFcreacion() {
		return fcreacion;
	}

	public void setFcreacion(Date fcreacion) {
		this.fcreacion = fcreacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	



	@Override
	public String toString() {
		return "Newsletter [idnewsletter=" + idnewsletter + ", fcreacion=" + fcreacion + ", titulo=" + titulo
				+ ", body=" + body + ", activo=" + activo + ", archivo=" + archivo + ", mailings=" + mailings + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idnewsletter ^ (idnewsletter >>> 32));
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
		Newsletter other = (Newsletter) obj;
		if (idnewsletter != other.idnewsletter)
			return false;
		return true;
	}

	

	

}

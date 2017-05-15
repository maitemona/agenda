package com.ipartek.formacion.contacto;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistencia.Contacto;
@Remote
public interface ContactoServiceRemote{
	
	public Contacto create(Contacto contacto);
	
	public List<Contacto> getAll();
	
	public Contacto getById(long codigo);
	
	public Contacto update(Contacto contacto);
	
	public void delete(long codigo);

	public List<Contacto> getByIdcategoria(long codigo);
	

}

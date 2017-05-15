
package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.contacto.ContactoServiceRemote;

import com.ipartek.formacion.persistencia.Contacto;



public interface ContactoService {
	
	public void setContactoServiceRemote(ContactoServiceRemote contactoService);
	
	public Contacto getById(long codigo);
	
	public List<Contacto> getAll();
	public List<Contacto> getIdcategoria(long codigo);
	
	public Contacto create(Contacto contacto);
	
	public Contacto update(Contacto contacto);
	
	public void delete(long codigo);

}



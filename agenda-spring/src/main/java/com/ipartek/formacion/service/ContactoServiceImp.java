package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ipartek.formacion.contacto.ContactoServiceRemote;
import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.persistencia.Contacto;
import com.ipartek.formacion.service.interfaces.ContactoService;

@Service("contactoServiceImp")//le pongo el nombre del beans que tengo en el xml
public class ContactoServiceImp implements ContactoService{

	@Resource(name = "contactoServiceRemote")//siempre se accede asi por si acaso
	private ContactoServiceRemote contactoServiceRemote;
	
	@Override
	public void setContactoServiceRemote(ContactoServiceRemote contactoService) {
		this.contactoServiceRemote= contactoService;
		
	}

	@Override
	public Contacto getById(long codigo) {
		return contactoServiceRemote.getById(codigo);
	}

	@Override
	public List<Contacto> getAll() {
		return contactoServiceRemote.getAll();
	}

	@Override
	public Contacto create(Contacto contacto) {
		return contactoServiceRemote.create(contacto);
	}

	@Override
	public Contacto update(Contacto contacto) {
		return contactoServiceRemote.update(contacto);
	}

	@Override
	public void delete(long codigo) {
		Contacto contacto = contactoServiceRemote.getById(codigo);
		contacto.setActivo(false);
		contactoServiceRemote.update(contacto);	
		
	}

	@Override
	public List<Contacto> getIdcategoria(long codigo) {
		return contactoServiceRemote.getByIdcategoria(codigo);
	}

	

}


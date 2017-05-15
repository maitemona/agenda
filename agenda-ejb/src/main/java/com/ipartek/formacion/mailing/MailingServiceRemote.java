package com.ipartek.formacion.mailing;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistencia.Contacto;
import com.ipartek.formacion.persistencia.Mailing;

@Remote
public interface MailingServiceRemote {
	
	public Mailing getById(long codigo);
	
	public List<Mailing> getAll();
	
	public Mailing create(Mailing mailing);
	
	//public Contacto update(Contacto contacto);
	
	public void delete(long codigo);

}

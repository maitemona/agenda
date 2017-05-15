package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.mailing.MailingServiceRemote;
import com.ipartek.formacion.persistencia.Mailing;

public interface MailingService {
	
	public void setMailingServiceRemote(MailingServiceRemote mailingService);
	
	public Mailing getById(long codigo);
	
	public List<Mailing> getAll();
	
	public Mailing create(Mailing mailing);
	
	//public Contacto update(Contacto contacto);
	
	public void delete(long codigo);


}

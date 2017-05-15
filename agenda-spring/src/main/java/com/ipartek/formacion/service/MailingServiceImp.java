package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.ipartek.formacion.mailing.MailingServiceRemote;

import com.ipartek.formacion.persistencia.Mailing;
import com.ipartek.formacion.service.interfaces.MailingService;

@Service("mailingServiceImp")//le pongo el nombre del beans que tengo en el xml
public class MailingServiceImp implements MailingService{
	@Resource(name = "mailingServiceRemote")//siempre se accede asi por si acaso
	private MailingServiceRemote mailingServiceRemote;
	
	
	@Override
	public void setMailingServiceRemote(MailingServiceRemote mailingService) {
		this.mailingServiceRemote= mailingService;
		
	}

	@Override
	public Mailing getById(long codigo) {
		return mailingServiceRemote.getById(codigo);
	}

	@Override
	public List<Mailing> getAll() {
		return null;
	}

	@Override
	public Mailing create(Mailing mailing) {
		return mailingServiceRemote.create(mailing);
	}

	@Override
	public void delete(long codigo) {
		mailingServiceRemote.delete(codigo);
		
	}

}

package com.ipartek.formacion.service;


import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.controller.ContactoController;
import com.ipartek.formacion.newsletter.NewsletterServiceRemote;
import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.persistencia.Newsletter;
import com.ipartek.formacion.service.interfaces.NewsletterService;


@Service("newsletterServiceImp")//le pongo el nombre del beans que tengo en el xml
public class NewsletterServiceImp implements NewsletterService{

	private static final Logger logger = LoggerFactory.getLogger(NewsletterServiceImp.class);
	@Resource(name = "newsletterServiceRemote")//siempre se accede asi por si acaso
	private NewsletterServiceRemote newsletterServiceRemote;
	
	@Override
	public void setNewsletterServiceRemote(NewsletterServiceRemote newsService) {
		this.newsletterServiceRemote= newsService;
		
	}

	@Override
	public Newsletter getById(long codigo) {
		return newsletterServiceRemote.getById(codigo);
	}

	@Override
	public List<Newsletter> getAll() {
		return newsletterServiceRemote.getAll();
	}

	@Override
	public Newsletter create(Newsletter news) {
		return newsletterServiceRemote.create(news);
	}

	@Override
	public Newsletter update(Newsletter news) {
		return newsletterServiceRemote.update(news);
	}

	@Override
	public void delete(long codigo) {
		logger.trace("pasa por delete() de Newsklettrs:"+codigo);
		Newsletter news = newsletterServiceRemote.getById(codigo);
		news.setActivo(false);
		newsletterServiceRemote.update(news);	
		
	}

}

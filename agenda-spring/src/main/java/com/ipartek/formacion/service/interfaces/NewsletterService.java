package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.newsletter.NewsletterServiceRemote;
import com.ipartek.formacion.persistencia.Newsletter;




public interface NewsletterService {
	
public void setNewsletterServiceRemote(NewsletterServiceRemote newsService);
	
	public Newsletter getById(long codigo);
	
	public List<Newsletter> getAll();
	
	public Newsletter create(Newsletter news);
	
	public Newsletter update(Newsletter news);
	
	public void delete(long codigo);

}

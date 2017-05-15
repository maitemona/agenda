package com.ipartek.formacion.newsletter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.persistencia.Newsletter;

@Stateless(name = "newsletterServiceBean")
public class NewsletterServiceBean implements NewsletterServiceRemote{

	@PersistenceContext(unitName="gestionagenda")
	private EntityManager entityManager;
	
	@Override
	public Newsletter create(Newsletter news) {
		try{
			news = entityManager.merge(news);
			
		}catch(Exception e){
			
		}
		
		return news;
	}

	@Override
	public List<Newsletter> getAll() {
		TypedQuery<Newsletter> news = entityManager.createNamedQuery("newsletter.getAll", Newsletter.class);
		return news.getResultList();
	}

	@Override
	public Newsletter getById(long codigo) {
		Newsletter news = entityManager.find(Newsletter.class, codigo);
		return news;
	}

	@Override
	public Newsletter update(Newsletter news) {
		try{
			news = entityManager.merge(news);
			
		}catch(Exception e){
			
		}
		
		return news;
	}

	@Override
	public void delete(long codigo) {
		// TODO Auto-generated method stub
		
	}

}

package com.ipartek.formacion.mailing;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import com.ipartek.formacion.persistencia.Mailing;
                 
@Stateless(name = "mailingServiceBean")
public class MailingServiceBean implements MailingServiceRemote{

	 @PersistenceContext(unitName="gestionagenda")
	 private EntityManager entityManager;

	@Override
	public Mailing getById(long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mailing> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mailing create(Mailing mailing) {
	
			mailing = entityManager.merge(mailing);
			//entityManager.flush();
		
	
		return mailing;
	}


	@Override
	public void delete(long codigo) {
		// TODO Auto-generated method stub
		
	}
	 
		
		
}

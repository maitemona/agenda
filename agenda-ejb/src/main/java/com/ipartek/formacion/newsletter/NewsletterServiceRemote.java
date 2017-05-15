package com.ipartek.formacion.newsletter;

import java.util.List;

import javax.ejb.Remote;
import com.ipartek.formacion.persistencia.Newsletter;

@Remote
public interface NewsletterServiceRemote {
	
	public Newsletter create(Newsletter news);
	
	public List<Newsletter> getAll();
	
	public Newsletter getById(long codigo);
	
	public Newsletter update(Newsletter news);

	public void delete(long codigo);

}

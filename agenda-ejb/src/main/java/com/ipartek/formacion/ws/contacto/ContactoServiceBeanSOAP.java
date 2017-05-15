package com.ipartek.formacion.ws.contacto;


import java.util.List;

import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.jws.WebService;

import com.ipartek.formacion.contacto.ContactoServiceRemote;
import com.ipartek.formacion.persistencia.Contacto;



/**
 * Session Bean implementation class CursoServiceBeanSAOP
 */
@WebService(endpointInterface="com.ipartek.formacion.ws.contacto.ContactoServiceBeanSOAPRemote",serviceName="contactoService")
@Stateless(name = "ContactoServiceSOAP")
public class ContactoServiceBeanSOAP implements ContactoServiceBeanSOAPRemote {

	/*qiueremos un objeto xe tipo ejb==beans 
	 * (todos los soap son ejb), como el autowired pero para ejb*/
	@EJB
	ContactoServiceRemote cS;
    /**
     * Default constructor. 
     */
    public ContactoServiceBeanSOAP() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Contacto> getAll() {
		// TODO Auto-generated method stub
		return cS.getAll();
	}

}

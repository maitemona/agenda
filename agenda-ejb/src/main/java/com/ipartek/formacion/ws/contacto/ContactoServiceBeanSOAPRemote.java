package com.ipartek.formacion.ws.contacto;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.ipartek.formacion.persistencia.Contacto;




@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
@WebService
@Remote
public interface ContactoServiceBeanSOAPRemote {
	
	@WebMethod(operationName="obtenerTodos")
	public List<Contacto> getAll();
 
}

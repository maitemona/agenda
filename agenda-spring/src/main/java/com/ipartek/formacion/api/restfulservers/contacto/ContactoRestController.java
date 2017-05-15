package com.ipartek.formacion.api.restfulservers.contacto;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ipartek.formacion.persistencia.Contacto;
import com.ipartek.formacion.service.interfaces.ContactoService;
/*
 * http://gestionagenda/api/contacto/1
 * metodo : get
 * respuesta codigo HTTP(el protocolo de estado de http siempre se devuelve)
 * 			contacto serializado en json, xml, html...
 * y la clase de spring que me gestiona esto es ResponseEntity
 * 
 * CrossFilter choca con jboss pq ya tenemos una inyection que es @crossorigin, dejo el crossfilter pero no vale,
 * lo puedo poner a nivel de clase, metodo y a nivel de proyecto mirar el servlet - contetx
 */
@CrossOrigin(origins="*" ,maxAge = 3600 , methods = {RequestMethod.GET ,RequestMethod.POST , RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/contactos" )
public class ContactoRestController implements Serializable {

	private static final long serialVersionUID = -6698866485450376235L;
	@Autowired
	ContactoService cS;
	
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Contacto>> getAll(){
		
		List<Contacto> contactos = cS.getAll(); 
		ResponseEntity<List<Contacto>> reponse = null;
		if(contactos == null || contactos.isEmpty()){//204
			 reponse = new ResponseEntity<List<Contacto>>(HttpStatus.NO_CONTENT);
		 }else{//200
			 reponse = new ResponseEntity<List<Contacto>>(contactos , HttpStatus.OK);
		 }
		return reponse;
	}
	
	 @RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<List<Contacto>> getByIdcategoria(@PathVariable("codigo") long id){
			
		 	List<Contacto> contactos = cS.getIdcategoria(id); 
			ResponseEntity<List<Contacto>> reponse = null;
					
			 if(contactos == null){//404
				 reponse = new ResponseEntity<List<Contacto>>(HttpStatus.NOT_FOUND);
			 }else{//200
				 reponse = new ResponseEntity<List<Contacto>>(contactos , HttpStatus.OK);
			 }
			
			return reponse;
		}
		
}

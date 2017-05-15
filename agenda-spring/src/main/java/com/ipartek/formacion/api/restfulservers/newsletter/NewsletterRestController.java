package com.ipartek.formacion.api.restfulservers.newsletter;

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


import com.ipartek.formacion.persistencia.Newsletter;

import com.ipartek.formacion.service.interfaces.NewsletterService;
/*
 * http://gestionagenda/api/newsletter/1
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
@RequestMapping(value = "/api/newsletters" )
public class NewsletterRestController implements Serializable {

	private static final long serialVersionUID = -6698866485450376235L;
	@Autowired
	NewsletterService nS;
	
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Newsletter>> getAll(){
		
		List<Newsletter> newsletters = nS.getAll(); 
		ResponseEntity<List<Newsletter>> reponse = null;
		if(newsletters == null || newsletters.isEmpty()){//204
			 reponse = new ResponseEntity<List<Newsletter>>(HttpStatus.NO_CONTENT);
		 }else{//200
			 reponse = new ResponseEntity<List<Newsletter>>(newsletters , HttpStatus.OK);
		 }
		return reponse;
	}
	 @RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Newsletter> getById(@PathVariable("codigo") int id){
			//recogemos un obejto alumno
			Newsletter news = nS.getById(id);
			//recogemos un objeto ResponseEntity
			ResponseEntity<Newsletter> reponse = null;
					
			 if(news == null){//404
				 reponse = new ResponseEntity<Newsletter>(HttpStatus.NOT_FOUND);
			 }else{//200
				 reponse = new ResponseEntity<Newsletter>(news , HttpStatus.OK);
			 }
			
			return reponse;
		}

	
}

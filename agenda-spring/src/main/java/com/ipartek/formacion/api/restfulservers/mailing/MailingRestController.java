package com.ipartek.formacion.api.restfulservers.mailing;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ipartek.formacion.persistencia.Mailing;
import com.ipartek.formacion.service.interfaces.MailingService;


@CrossOrigin(origins="*" ,maxAge = 3600 , methods = {RequestMethod.GET ,RequestMethod.POST , RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/mailings" )
public class MailingRestController implements Serializable {

	private static final long serialVersionUID = -6698866485450376235L;
	@Autowired
	MailingService mS;
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	/*public ResponseEntity<List<Mailing>>  g{
		
		List<Mailing> mailings = mS.getAll(); 
		ResponseEntity<List<Mailing>> reponse = null;
		if(mailings == null || mailings.isEmpty()){//204
			 reponse = new ResponseEntity<List<Mailing>>(HttpStatus.NO_CONTENT);
		 }else{//200
			 reponse = new ResponseEntity<List<Mailing>>(mailings , HttpStatus.OK);
		 }
		return response;
	}*/
	public ResponseEntity<List<Mailing>> create(Mailing mailing){

		return null;
	}
	
}

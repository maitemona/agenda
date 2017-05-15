package com.ipartek.formacion.api.restfulservers.categoria;

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



import com.ipartek.formacion.persistencia.Categoria;

import com.ipartek.formacion.service.interfaces.CategoriaService;


@CrossOrigin(origins="*" ,maxAge = 3600 , methods = {RequestMethod.GET ,RequestMethod.POST , RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/categorias" )
public class CategoriaRestController implements Serializable {

	private static final long serialVersionUID = -6698866485450376235L;
	@Autowired
	CategoriaService cS;
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Categoria>> getAll(){
		
		List<Categoria> categorias = cS.getAll(); 
		ResponseEntity<List<Categoria>> reponse = null;
		if(categorias == null || categorias.isEmpty()){//204
			 reponse = new ResponseEntity<List<Categoria>>(HttpStatus.NO_CONTENT);
		 }else{//200
			 reponse = new ResponseEntity<List<Categoria>>(categorias , HttpStatus.OK);
		 }
		return reponse;
	}
	
	 @RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Categoria> getById(@PathVariable("codigo") int id){
			//recogemos un obejto alumno
			Categoria categoria = cS.getById(id);
			//recogemos un objeto ResponseEntity
			ResponseEntity<Categoria> reponse = null;
					
			 if(categoria == null){//404
				 reponse = new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			 }else{//200
				 reponse = new ResponseEntity<Categoria>(categoria , HttpStatus.OK);
			 }
			
			return reponse;
		}

	
	
}

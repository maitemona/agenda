package com.ipartek.formacion.api.restfulservers.categoria;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


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

	
		@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Void> create(@Valid @RequestBody Categoria categoria, UriComponentsBuilder ucBuilder){
			
			
			//validamos que ese alumno esixta o no con el metos getByDni
			Categoria cate= cS.getById((categoria.getIdcategoria()));
			ResponseEntity<Void> response = null;
			if(cate != null){//409
				response = new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}else{//300
				try{
					//recogo el objeto por el codigo
					Categoria aux = cS.create(categoria);
					//paar devolver el obejto garbado en bbdd, hay que manipular los encabezados de HTTP
					//vamos a llamar al metodo  ResponseEntity<Alumno> getById
					//response = new ResponseEntity<Void>(HttpStatus.CREATED);
					HttpHeaders headers = new HttpHeaders();
					headers.setLocation(ucBuilder.path("/api/categoria/{codigo}").buildAndExpand(aux.getIdcategoria()).toUri());
					response = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
				}catch(Exception e){
					response = new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
				}
			}
			return response;
		}
		
		@RequestMapping(value = "/{codigo}", consumes = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.PUT, produces = {
							MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<Categoria> update(@PathVariable("codigo") int id,@Valid @RequestBody Categoria categoria){
			Categoria cate = cS.getById(id);
			//recogemos un objeto ResponseEntity
			ResponseEntity<Categoria> response = null;			
			if(cate == null){
			response =  new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}else{
				cate = cS.update(categoria);
				//paar devolver el obejto garbado en bbd
				response =  new ResponseEntity<Categoria>(cate , HttpStatus.ACCEPTED);
			}
			
			return response;
		}

}

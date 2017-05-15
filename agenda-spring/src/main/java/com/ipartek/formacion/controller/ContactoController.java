package com.ipartek.formacion.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.ipartek.formacion.persistencia.Categoria;

import com.ipartek.formacion.persistencia.Contacto;

import com.ipartek.formacion.service.interfaces.CategoriaService;
import com.ipartek.formacion.service.interfaces.ContactoService;

@Controller
@RequestMapping(value = "/contactos")
public class ContactoController {

	/*busca una clase q lo implemente(@Autowired)*/
	@Inject // @Autowired
	private ContactoService cS;
	@Autowired
	private CategoriaService catS;
	private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);
	ModelAndView mav = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		logger.info("Controller lista size:");
		mav = new ModelAndView("/contactos/contactos");
		//Cargar a cargar lista de clientes
		List<Contacto> contactos = cS.getAll();
		//Engancharla  al modelandview
		logger.info("Controller lista size:"+contactos.size());
		mav.addObject("listadoContactos",contactos);
		logger.trace("pasa por getAll() de contactos");
		return mav; 
	}	
	
	@RequestMapping(value = "/{id}")
	public ModelAndView getByid(@PathVariable("id") int id){
	//	List<Categoria> categorias = catS.getAll();
		mav = new ModelAndView("/contactos/contacto");
		mav.addObject("contacto", cS.getById(id));
		//mav.addObject("categorias", catS.getById(codigo))
		return mav;
	}
	
	@RequestMapping(value = "/addContacto")
	public String addAlumno(Model model){
		model.addAttribute("contacto",new Contacto());
		model.addAttribute("listadoCategorias",catS.getAll());
		return "/contactos/contacto";
	}
	
	@RequestMapping(value="/save",method =  RequestMethod.POST)
	public String saveContacto (Model model , @ModelAttribute("contacto") @Valid Contacto contacto, BindingResult bindingResult ){
		String destino ="";
		/*si las cosas estan mal nos mande de vuelta*/
		if(bindingResult.hasErrors()){
			logger.info("contacto tiene errores");
			logger.info("AQUI"+contacto.toString());
			model.addAttribute("listadoCategorias",catS.getAll());
			destino = "/contactos/contacto";
		}else{ 
			destino = "redirect:/contactos";
			if(contacto.getIdcontacto() > Contacto.CODIGO_NULO){
				logger.info("AQUI"+contacto.toString());
				cS.update(contacto);
			}else{
				logger.info("Objeto:"+contacto.toString());
				logger.info("CAtegoria del contacto"+contacto.getCategoria().toString());
				cS.create(contacto);
			}
		}
		return destino;
	}
	@RequestMapping(value = "/deleteContacto/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {
	//	logger.info("Objeto a borrar:"+contacto.toString());
		cS.delete(codigo);
		return "redirect:/contactos";
	}
			
	@RequestMapping(value = "/editContacto/{codigo}", method = RequestMethod.GET)
	public ModelAndView editContacto(@PathVariable("codigo") long codigo) {
		mav = new ModelAndView("/contactos/contacto");
		Contacto contacto = cS.getById(codigo);
		logger.info("Sacar contacto de :codigo-"+codigo + " " + contacto.toString());
		mav.addObject("contacto", contacto);
		List<Categoria> categoria = catS.getAll();
		mav.addObject("listadoCategorias", categoria);
		return mav;
	}
	
	
	
	
}


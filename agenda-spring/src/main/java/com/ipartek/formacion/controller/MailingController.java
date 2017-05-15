package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.controller.pojo.Mensaje;
import com.ipartek.formacion.controller.pojo.MensajeType;
import com.ipartek.formacion.persistencia.Categoria;

import com.ipartek.formacion.persistencia.Mailing;
import com.ipartek.formacion.persistencia.Newsletter;
import com.ipartek.formacion.service.interfaces.CategoriaService;

import com.ipartek.formacion.service.interfaces.MailingService;
import com.ipartek.formacion.service.interfaces.NewsletterService;

@Controller
@RequestMapping(value = "/mailing")
public class MailingController {

	@Inject // @Autowired
	private MailingService mS;
	@Autowired
	private CategoriaService catS;
	@Autowired
	private NewsletterService nS;
	private static final Logger logger = LoggerFactory.getLogger(MailingController.class);
	ModelAndView mav = null;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		//binder.setValidator(validator);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView crear() {
		logger.info("Proceso de creacion de envio de mailing:");
		mav = new ModelAndView("/mailing/mailing");
		//Cargar a cargar lista de clientes
		List<Categoria> categorias = catS.getAll();
		List<Newsletter> newsletters = nS.getAll();
		//Engancharla  al modelandview
		logger.info("Controller lista size:"+categorias.size());
		mav.addObject("listadoCategorias",categorias);
		mav.addObject("listadoNewsletters",newsletters);
		mav.addObject("mailing", new Mailing());
	
		//return "/contactos/contacto";
		return mav; 
	}	
	
	
	@RequestMapping(value="/save",method =  RequestMethod.POST)
	public String saveCurso(@ModelAttribute(name = "mailing") @Valid Mailing mailing, BindingResult bindingResult,
			ModelMap model,RedirectAttributes redirectMap){
		String destino ="";
		Mensaje mensaje=null;
		String txt="";
		/*si las cosas estan mal nos mande de vuelta*/
		if(bindingResult.hasErrors()){
			logger.info("mailing tiene errores");
			model.addAttribute("listadoCategorias",catS.getAll());
			model.addAttribute("listadoNewsletters",nS.getAll());
			txt="Errores en los datos del formulario";
			mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
			model.addAttribute("mensaje",mensaje);
			destino = "mailing/mailing";
		}else{ 
			destino = "redirect:/mailing/";
			logger.info("AQUI create:"+mailing.toString());
			try{
				logger.error("Se ha lanzado una excepcion en el envio");
				mS.create(mailing);
				txt ="Mailing enviado corectamente";
				mensaje =new Mensaje(MensajeType.MSG_TYPE_SUCCESS);
				logger.info("mensaje"+mensaje);
			}catch(Exception e){
				logger.error("Se ha lanzado una excepcion en el envio");
				txt = "Ha habido problemas en el envio";	
				mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
				
			}
		}
		mensaje.setMsg(txt);
		redirectMap.addFlashAttribute("mensaje",mensaje);
		
		return destino;
	}
	
	
}

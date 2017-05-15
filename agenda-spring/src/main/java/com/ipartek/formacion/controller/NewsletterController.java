package com.ipartek.formacion.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.controller.validator.FileValidator;
import com.ipartek.formacion.persistencia.Newsletter;

import com.ipartek.formacion.service.interfaces.NewsletterService;

@Controller
@RequestMapping(value = "/newsletters")
public class NewsletterController {
	
	/*busca una clase q lo implemente(@Autowired)*/
	 @Autowired
	private NewsletterService nS;
	
	 
	/////Queremos que nos metan el contexto de los servlet, queiro el context path , de (resources/docs)
	@Autowired
	private ServletContext servletContext;
		
	private static final Logger logger = LoggerFactory.getLogger(NewsletterController.class);
	ModelAndView mav = null;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		//binder.setValidator(validator);
	}
	
	@InitBinder("fichero")
	public void initBinderfichero(WebDataBinder binder) {
		
		binder.addValidators(new FileValidator());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		
		mav = new ModelAndView("/newsletters/newsletters");
		//Cargar a cargar lista de clientes
		List<Newsletter> news = nS.getAll();
		//Engancharla  al modelandview
		logger.info("Controller lista news size:"+news.size());
		mav.addObject("listadoNews",news);
		logger.trace("pasa por getAll() de Newsletters");
		return mav; 
	}	
	
	@RequestMapping(value = "/{codigo}")
	public String getByid(@PathVariable("codigo") long codigo,Model model){
		model.addAttribute("news", nS.getById(codigo));
		return "newsletters/newsletter";
	}
	@RequestMapping(value = "/addNewsletter")
	public String addAlumno(Model model){
		model.addAttribute("news",new Newsletter());
		return "newsletters/newsletter";
	}

	@RequestMapping(value = "/deleteNewsletter/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {
		logger.trace("pasa por delete() de Newsklettrs");
		nS.delete(codigo);
		return "redirect:/newsletters";
	}
	
	
	@RequestMapping(value="/save",method =  RequestMethod.POST)
	public String saveContacto(@Valid @RequestParam("fichero") MultipartFile  file,
			@ModelAttribute("news") @Valid Newsletter news, BindingResult bindingResult,ModelMap model )throws IOException{
		String destino ="";
		/*si las cosas estan mal nos mande de vuelta*/
		if(bindingResult.hasErrors()){
			logger.info("Newsletter tiene errores");
			logger.info("AQUI"+news.toString());
			destino = "newsletters/newsletter";
		}else{ 
			destino = "redirect:/newsletters";
			//obtengo el archivo
			InputStream in= file.getInputStream();
			String root = File.separator + "resources" + File.separator + "docs" ;
			String ruta=servletContext.getRealPath(root);
			File destination = new File(ruta +File.separator+file.getOriginalFilename());
			if (!destination.isDirectory()) {
				FileUtils.copyInputStreamToFile(in, destination);
				logger.info(destination.getAbsolutePath());
			}
			logger.info(ruta);
		//	logger.info("Destino"+destination);
			//guardo dentro de newsleter ----  boletin
			news.setArchivo(file.getOriginalFilename());
			if(news.getIdnewsletter() > Newsletter.CODIGO_NULO){
				logger.info("AQUI"+news.toString());
				nS.update(news);
			}else{
				logger.info("Objeto:"+news.toString());
				
				nS.create(news);
			}
		}
		return destino;
	}
}

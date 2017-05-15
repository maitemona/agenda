package com.ipartek.formacion.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.controller.pojo.Mensaje;
import com.ipartek.formacion.controller.pojo.MensajeType;
import com.ipartek.formacion.persistencia.Categoria;

import com.ipartek.formacion.service.interfaces.CategoriaService;


/**
 * Vamos a procersar las peticiones de categorias
 * crear nueva categoria
 * borrar categoria
 * editar categotia
 * listar todas las categorias
 * @author mai
 *
 */
@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService cS;
	private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model){
		model.addAttribute("listadoCategorias",cS.getAll());
	//	logger.info("Controller lista size:"+listadoCategorias.size());
	
		return"categorias/categorias";
		
	}
	@RequestMapping(value = "/{codigo}")
	public String getByid(@PathVariable("codigo") long codigo,Model model){
		model.addAttribute("categoria", cS.getById(codigo));
		return "categorias/categoria";
	}
	@RequestMapping(value = "/addCategoria")
	public String addAlumno(Model model){
		model.addAttribute("categoria",new Categoria());
		return "categorias/categoria";
	}
	
	@RequestMapping(value="/save",method =  RequestMethod.POST)
	public String saveContacto (@ModelAttribute("categoria") @Valid Categoria categoria,
			BindingResult bindingResult,Model model,RedirectAttributes redirectMap ){
		String destino ="";
		Mensaje mensaje=null;
		String txt="";
		/*si las cosas estan mal nos mande de vuelta*/
		if(bindingResult.hasErrors()){
			logger.info("categoria tiene errores");
			mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
			txt="Errores en los datos del formulario";
			model.addAttribute("mensaje",mensaje);
			destino = "categorias/categoria";
		}else{ 
			destino = "redirect:/categorias";
			if(categoria.getIdcategoria() > Categoria.CODIGO_NULO){
				logger.info("AQUI"+categoria.toString());
				try{
					cS.update(categoria);
					txt ="La categoría se ha actualizado correctamente";
					mensaje =new Mensaje(MensajeType.MSG_TYPE_SUCCESS);
				}catch(Exception e){
					logger.error("Se ha lanzado una excepcion en update");
					txt = "Ha habido problemas en la update";	
					mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
					
				}
			}else{
				logger.info("Objeto:"+categoria.toString());
				
				try{
					cS.create(categoria);
					txt ="la categoria se ha creado correctamente";
					mensaje =new Mensaje(MensajeType.MSG_TYPE_SUCCESS);
					logger.info("mensaje"+mensaje);
				}catch(Exception e){
					logger.error("Se ha lanzado una excepcion en create");
					txt = "Ha habido problemas en la creación";
					mensaje = new Mensaje(MensajeType.MSG_TYPE_DANGER);
					
				}
			}
			mensaje.setMsg(txt);
			redirectMap.addFlashAttribute("mensaje",mensaje);
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteCategoria/{codigo}")
	public String delete(@PathVariable("codigo") int codigo) {
	
		cS.delete(codigo);
		return "redirect:/categorias";
	}


}

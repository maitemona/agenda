package com.ipartek.formacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.controller.pojo.Mensaje;
import com.ipartek.formacion.controller.pojo.MensajeType;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.trace("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		logger.info("ESTOY EN HOME");
		return "home";
	}
	//que nos preocese el login.html y el access-deneger
		@RequestMapping(value="login")
		public String loginPage(Locale locale, Model model){
			logger.info("ESTOY EN Login");
			Mensaje mensaje=null;
			String txt="";
			txt ="Te has logeado correctamente";
			mensaje =new Mensaje(MensajeType.MSG_TYPE_SUCCESS);
			//me redirige a login.jsp
			mensaje.setMsg(txt);
			model.addAttribute("mensaje", mensaje);
			//redirectMap.addFlashAttribute("mensaje",mensaje);
			return "login";
		}
	/*
		@RequestMapping(method = RequestMethod.GET, value = "/login.html")
		public String accessLogin() {
			
			logger.info("ESTOY accessLogin()");
			return "redirect:/login";
		}*/
		//estamos con trabajando con clases especificas de segurity
	@RequestMapping(value="Access_Denied")
		public String accessoDenegado(ModelMap model){
			//necesito el mapa para mostrar el mensaje de error en la pagina de login,
			//vamos a crear un metodo getPrincipal, para validar desde xml
			model.addAttribute("user", getPrincipal());
			return "login";
		}
		private String getPrincipal() {
			String username= null;
			//lista de usuarios del contexto
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principal instanceof UserDetails)
			{
				username =((UserDetails) principal).getUsername();
			}
			else{
				username = principal.toString();
				
			}
			return username;
		}
		
		@RequestMapping(value="logout")
		public String logout(HttpServletRequest request,HttpServletResponse response){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth != null){
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/login?logout";//se recomienda asi la pagina d elogout sea la de login
			
		}

}

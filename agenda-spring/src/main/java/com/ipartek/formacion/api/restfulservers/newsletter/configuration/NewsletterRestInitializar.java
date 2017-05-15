package com.ipartek.formacion.api.restfulservers.newsletter.configuration;



import javax.servlet.Filter;

import com.ipartek.formacion.api.restfulservers.CORSFilter;

public class NewsletterRestInitializar {
protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{NewsletterRestControllerConfiguration.class};
	}


	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}


	protected String[] getServletMappings() {
		return new String[]{"/"};
	}


	protected Filter[] getServletFilters() {
		Filter[] filter = {new CORSFilter() };
		return filter;
	}


}

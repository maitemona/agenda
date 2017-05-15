package com.ipartek.formacion.api.restfulservers.categoria.configuration;



import javax.servlet.Filter;

import com.ipartek.formacion.api.restfulservers.CORSFilter;

public class CategoriaRestInitializar {
protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{CategoriaRestControllerConfiguration.class};
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

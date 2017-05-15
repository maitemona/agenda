package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.service.interfaces.CategoriaService;



public class CategoriaConverter implements Converter<String,Categoria>{
	private static final Logger logger = LoggerFactory.getLogger(CategoriaConverter.class);

	@Autowired 
	CategoriaService cS;
	@Override
	public Categoria convert(String arg0) {
		logger.info(arg0.toString());
		return cS.getById(Long.parseLong((String) arg0));
	}

}

package com.ipartek.formacion.controller.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ipartek.formacion.persistencia.Newsletter;
import com.ipartek.formacion.service.interfaces.NewsletterService;




public class NewsletterConverter implements Converter<String,Newsletter>{
	private static final Logger logger = LoggerFactory.getLogger(NewsletterConverter.class);
	@Autowired 
	NewsletterService nS;
	@Override
	public Newsletter convert(String arg0) {
		logger.info(arg0.toString());
		return nS.getById(Long.parseLong((String) arg0));
	}

}

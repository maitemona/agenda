package com.ipartek.formacion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.ipartek.formacion.categoria.CategoriaServiceRemote;
import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.service.interfaces.CategoriaService;



@Service("categoriaServiceImp")//le pongo el nombre del beans que tengo en el xml
public class CategoriaServiceImp implements CategoriaService{

	@Resource(name = "categoriaServiceRemote")//siempre se accede asi por si acaso
	private CategoriaServiceRemote categoriaServiceRemote;
	
	@Override
	public void setCategoriaServiceRemote(CategoriaServiceRemote categoriaService) {
		this.categoriaServiceRemote= categoriaService;
		
	}
	@Override
	public Categoria getById(long codigo) {
		return categoriaServiceRemote.getById(codigo);
	}

	@Override
	public List<Categoria> getAll() {
		return categoriaServiceRemote.getAll();
		
	}
	@Override
	public Categoria create(Categoria categoria) {
		return categoriaServiceRemote.create(categoria);
	}
	@Override
	public Categoria update(Categoria categoria) {
		return categoriaServiceRemote.update(categoria);
	}
	@Override
	public void delete(long codigo) {
		Categoria categoria = categoriaServiceRemote.getById(codigo);
		categoria.setActivo(false);
		categoriaServiceRemote.update(categoria);		
	}

}

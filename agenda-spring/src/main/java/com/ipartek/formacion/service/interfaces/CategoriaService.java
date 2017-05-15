package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.categoria.CategoriaServiceRemote;
import com.ipartek.formacion.persistencia.Categoria;



public interface CategoriaService {
	
	public void setCategoriaServiceRemote(CategoriaServiceRemote categoriaService);
	
	public Categoria getById(long codigo);
	
	public List<Categoria> getAll();
	
	public Categoria create(Categoria categoria);
	
	public Categoria update(Categoria categoria);
	
	public void delete(long codigo);

}

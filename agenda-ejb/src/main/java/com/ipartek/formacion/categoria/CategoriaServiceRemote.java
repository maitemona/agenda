package com.ipartek.formacion.categoria;

import java.util.List;

import javax.ejb.Remote;

import com.ipartek.formacion.persistencia.Categoria;


@Remote
public interface CategoriaServiceRemote {
	
	public Categoria create(Categoria categoria);
	
	public List<Categoria> getAll();
	
	public Categoria getById(long codigo);
	
	public Categoria update(Categoria categoria);

	public void delete(long codigo);

}

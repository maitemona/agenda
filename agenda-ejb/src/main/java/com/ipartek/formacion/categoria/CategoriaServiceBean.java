package com.ipartek.formacion.categoria;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


import com.ipartek.formacion.persistencia.Categoria;



/**
 * Session Bean implementation class CategoriaServiceRemote
 */


@Stateless(name = "categoriaServiceBean")
public class CategoriaServiceBean implements CategoriaServiceRemote {
	@PersistenceContext(unitName="gestionagenda")
	private EntityManager entityManager;
	
	

	@Override
	public Categoria create(Categoria categoria) {
		
		//EntityTransaction txt = entityManager.getTransaction();
		//txt.begin();
		try{
			categoria = entityManager.merge(categoria);
			//txt.commit();
			//entityManager.flush();
		}catch(Exception e){
			//txt.rollback();
		}
		//entityManager.persist(curso);
		return categoria;
	}

	@Override
	public List<Categoria> getAll() {
		TypedQuery<Categoria> categorias = entityManager.createNamedQuery("categoria.getAll", Categoria.class);
		return categorias.getResultList();
	
	}
	
	@Override
	public Categoria getById(long codigo) {
		Categoria categoria = entityManager.find(Categoria.class, codigo);
		return categoria;
	}

	@Override
	public Categoria update(Categoria categoria) {
		//EntityTransaction txt = entityManager.getTransaction();
		//txt.begin();
		
		try{
			categoria = entityManager.merge(categoria);
		//	txt.commit();
		}catch(Exception e){
			System.out.println("ll"+e.getMessage());
			//txt.rollback();
		}
		//entityManager.persist(curso);
		return categoria;
	}

	@Override
	public void delete(long codigo) {
		/*
		try{
			entityManager.remove(entityManager.find(Categoria.class, codigo));

		}catch(Exception e){
			
		}
		*/
	}

}

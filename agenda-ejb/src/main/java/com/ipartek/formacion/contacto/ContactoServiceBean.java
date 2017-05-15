package com.ipartek.formacion.contacto;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;




import com.ipartek.formacion.persistencia.Contacto;



@Stateless(name = "contactoServiceBean")
public class ContactoServiceBean implements ContactoServiceRemote{

	 @PersistenceContext(unitName="gestionagenda")
	 private EntityManager entityManager;

	 
	@Override
	public Contacto create(Contacto contacto) {
		try{
			contacto = entityManager.merge(contacto);
			//entityManager.flush();
		}catch(Exception e){
			
		}
	
		return contacto;
	}

	@Override
	public List<Contacto> getAll() {
		TypedQuery<Contacto> contactos = entityManager.createNamedQuery("contacto.getAll", Contacto.class);
		return contactos.getResultList();
	}

	@Override
	public Contacto getById(long codigo) {
		
		Contacto contacto = entityManager.find(Contacto.class, codigo);
		//StoredProcedureQuery spq= entityManager.createNamedStoredProcedureQuery("curso.getAlumnos");
		//spq.setParameter(1,curso.getCodigo());
		//List<Alumno> alumnos = spq.getResultList();
		//curso.setAlumnos(alumnos);
		return contacto;
		/*Contacto contacto = entityManager.find(Contacto.class, codigo);
		StoredProcedureQuery spq= entityManager.createNamedStoredProcedureQuery("contacto.getContactos");
		spq.setParameter(1,contacto.getIdcontacto());
		List<Contacto> contactos = spq.getResultList();
	//	contactos.set(contacto);
		return contactos;
		*/
		
	}

	@Override
	public Contacto update(Contacto contacto) {
		try{
			contacto = entityManager.merge(contacto);
		
		}catch(Exception e){
			
		}
		
		return contacto;
	}

	@Override
	public void delete(long codigo) {
	
	}

	@Override
	public List<Contacto> getByIdcategoria(long codigo) {
		
		//Contacto contacto = entityManager.find(Contacto.class, codigo);
		 StoredProcedureQuery spq =entityManager.createNamedStoredProcedureQuery("contacto.getContactosporCategoria");
		spq.setParameter(1, codigo);
		List<Contacto> contactos = spq.getResultList();
	//	List<Contacto> contactos = (List<Contacto>) spq.getResultList(); 
				//categoria.setCategorias(categorias);(contactos);(contactos);
		//Contacto contacto = entityManager.find(Contacto.class, codigo);
		/*List<Contacto> contactos = null;
		StoredProcedureQuery spq= entityManager.createNamedStoredProcedureQuery("contacto.getContactosporCategoria");
	  spq.registerStoredProcedureParameter("codigo", Integer.class, ParameterMode.IN);
        spq.setParameter("codigo", contactos.get(0).getIdcontacto());
		//spq.setParameter(1,contacto.getIdcontacto());
		List<Contacto> contactos1 = spq.getResultList();
		*/
		return contactos;
	}
	
	

}



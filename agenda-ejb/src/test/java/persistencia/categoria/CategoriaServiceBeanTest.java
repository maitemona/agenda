package persistencia.categoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.io.File;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ipartek.formacion.categoria.CategoriaServiceRemote;

import com.ipartek.formacion.persistencia.Categoria;

///necesaria la clase arquillian 
@RunWith(Arquillian.class)
public class CategoriaServiceBeanTest {
	
	@Deployment
	public static Archive<?> createDeployment(){
		
		//cargar el archivo xml del pom de nuestro proyecto logico , pq necesitamos al common.
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                .withTransitivity().asFile();
        
        WebArchive wa = ShrinkWrap.create(WebArchive.class,"tets.war").
        		addClass(Categoria.class)
        		.addPackage(CategoriaServiceRemote.class.getPackage())
        		.addAsLibraries(files).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        		
        return wa;
	
	}
	
	@EJB
	CategoriaServiceRemote cS;
	
	Categoria categoria;
	int[] codigos;
	
	@Test
	public void testIsDeployed(){
		assertNotNull(cS);
	}
	
	
	
	
	//@Test(expected= DuplicateKeyException.class)
	@Test
	public void createTesting(){
		
	//	Categoria cat1 = cS.create(categoria);
	//	assertNotNull("La categoria es nulo", cat1 == null);
		categoria = new Categoria();
		categoria.setNcategoria("Prueba categoria");
		categoria.setActivo(true);
		Categoria cat = cS.create(categoria);
	    assertNotNull("la categoria es nula", cat == null);
	   // cS.delete(cat.getIdcategoria());
      
	}
	@Test
	public void getByIdTest() {
		codigos = new int[2];
		codigos[0]= 1;
		codigos[1] = 2;
		
		for (int i = 1; i < codigos.length; i++) {
			Categoria cat = cS.getById(codigos[i]);
			assertNotNull("La categoria tiene que existir. La categoria con codigo " 
			+ codigos[i] + " no esta en base de datos",
					cat);
			assertEquals("El codigo de la categoria no coincide. El codigo enviado es:" + codigos[i] + " y el recibido es:"
					+ cat.getIdcategoria(), codigos[i], cat.getIdcategoria());
		}
	}

}

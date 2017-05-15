package persistencia.contacto;

import static org.junit.Assert.assertNotNull;

import java.io.File;

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
import com.ipartek.formacion.contacto.ContactoServiceRemote;
import com.ipartek.formacion.persistencia.Categoria;
import com.ipartek.formacion.persistencia.Contacto;

///necesaria la clase arquillian 
@RunWith(Arquillian.class)
public class ContactoServiceBeanTest {
	@Deployment
	public static Archive<?> createDeployment(){
		//cargar el archivo xml del pom de nuestro proyecto logico , pq necesitamos al common.
        File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
                .withTransitivity().asFile();
        
        WebArchive wa = ShrinkWrap.create(WebArchive.class,"tets.war").
        		addClass(Contacto.class).addClass(Categoria.class)
        		.addPackage(ContactoServiceRemote.class.getPackage())
        		.addAsLibraries(files).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        		
        return wa;
	}
	@EJB
	ContactoServiceRemote cS;
	
	@Test
	public void testIsDeployed(){
		assertNotNull(cS);
	}
	@Test 
	public void createTest(){
		
	}
}

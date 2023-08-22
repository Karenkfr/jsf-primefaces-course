package erp.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private EntityManagerFactory emf;
	
	public EntityManagerProducer() {
		this.emf = Persistence.createEntityManagerFactory("exemplo-jsf");
	}
	
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.emf.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
}

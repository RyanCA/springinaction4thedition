package pland.com.springaction4thedition.data.jpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pland.com.springaction4thedition.data.Spitter;
import pland.com.springaction4thedition.data.SpitterRepository;

@Repository
@Transactional
public class SpringJPASpitterRepository implements SpitterRepository{

	/**
	 * @PersistenceUnit and @PersistenceContext are not Spring Annotation;
	 * In order to let Spring understand them and inject an EntityManagerFactory 
	 * or EntityManager, Spring’s PersistenceAnnotationBeanPostProcessor must 
	 * be configured
	 * Refer to 11.2.2
	 */
//	@PersistenceUnit
//	private EntityManagerFactory emf;
	
	@PersistenceContext 
	EntityManager em;

	public Spitter save(Spitter spitter) {
		System.out.println("This is in SpringJPASpitterRepository");
		em.persist(spitter);
		return new Spitter(spitter.getUsername(), 
				spitter.getPassword(), 
				spitter.getFirstName(),
				spitter.getLastName());
	}

	public Spitter findOne(long id) {
		return (Spitter) em.find(Spitter.class, id); 
	}

	public Spitter findByUsername(String username) {	
		return (Spitter) em.createQuery("select s from Spitter s where s.username=?").setParameter(1, username).getSingleResult();
	}

//	public List<Spitter> findAll() {
//		return (List<Spitter>) currentSession() 
//				.createCriteria(Spitter.class).list(); 
//	}

}

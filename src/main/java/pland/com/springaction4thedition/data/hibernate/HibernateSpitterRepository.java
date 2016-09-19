package pland.com.springaction4thedition.data.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pland.com.springaction4thedition.data.Spitter;
import pland.com.springaction4thedition.data.SpitterRepository;

//@Repository //Define it explicity through bean to avoid multiple SpitterRepository
public class HibernateSpitterRepository implements SpitterRepository{

	private SessionFactory sessionFactory;
	
	@Autowired //or @Inject
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public Spitter save(Spitter spitter) {
		System.out.println("This is in HibernateSpitterRepository");
		Serializable id = currentSession().save(spitter);
		return new Spitter((Long) id, 
				spitter.getUsername(), 
				spitter.getPassword(), 
				spitter.getFirstName(),
				spitter.getLastName());
	}

	public Spitter findOne(long id) {
		return (Spitter) currentSession().get(Spitter.class, id); 
	}

	public Spitter findByUsername(String username) {		
		return (Spitter) currentSession() 
				.createCriteria(Spitter.class) 
				.add(Restrictions.eq("username", username))
				.list().get(0);
	}

//	public List<Spitter> findAll() {
//		return (List<Spitter>) currentSession() 
//				.createCriteria(Spitter.class).list(); 
//	}

}

package com.empresa.model.db;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class UserDAOImpl implements UserDAO {

	@PersistenceContext(name="default")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsuarios() {
	    String queryString = "Select u from User u";
	    Query query = em.createQuery(queryString);
	    List<User> result = query.getResultList();
		return result;
	}

	@Override
	public void persist(User user) {
		em.persist(user);
	}

}

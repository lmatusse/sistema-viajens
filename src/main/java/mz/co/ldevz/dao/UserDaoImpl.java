package mz.co.ldevz.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mz.co.ldevz.entity.Usuario;

@Repository
public class UserDaoImpl implements UserDao {
	
	// dao pattern to deal with retrieve and send data to and from database for user

	// field injection entity manager
	@Autowired
	private EntityManager entityManager;

	// get user from database with email
	@Override
	public Usuario findUserByEmail(String email) {
		
		// create query with HQL to get user
		Query<Usuario> query = currentSession().createQuery("from User where user_email=:uEmail", Usuario.class);
		query.setParameter("uEmail", email);

		// check if valid user and is exist or null
		Usuario user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}
		
	// get user from databasr using username 
	@Override
	public Usuario findUserByUsername(String username) {
		
		// create query with HQL to get user
		Query<Usuario> query = currentSession().createQuery("from User where user_username=:uName", Usuario.class);
		query.setParameter("uName", username);

		// check if valid user and is exist or null
		Usuario user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}
	
	// create user and update if is exist
	@Override
	public void saveUser(Usuario theUser) {
		currentSession().saveOrUpdate(theUser);
	}

	// get current hibernate session
	private Session currentSession() {
		return entityManager.unwrap(Session.class);
	}
}

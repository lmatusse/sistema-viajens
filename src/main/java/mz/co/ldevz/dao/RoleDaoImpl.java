package mz.co.ldevz.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Perfil;
@Repository
public class RoleDaoImpl implements RoleDao {
	
	// dao pattern to deal with retrieve and send data to and from database for Role
	
	// field injection entity manager
	@Autowired
	private EntityManager entityManager;

	// retrieve role from database 
	@Override
	public Perfil findRoleByName(String roleName) {
		
		// create query with HQL to get role
		Query<Perfil> theQuery = currentSession().createQuery("from Role where role_name=:roleName", Perfil.class);
		theQuery.setParameter("roleName", roleName);
		
		// check of valid role and is exist or null
		Perfil theRole = null;
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}

	// get current hibernate session
	private Session currentSession() {
		return entityManager.unwrap(Session.class);
	}
}

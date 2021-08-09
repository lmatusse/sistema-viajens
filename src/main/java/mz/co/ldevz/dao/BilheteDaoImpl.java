package mz.co.ldevz.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mz.co.ldevz.entity.Bilhete;

@Repository
public class BilheteDaoImpl implements BilheteDao {
	
	// dao pattern to deal with retrieve and send data to and from database for reservation

	// field injection entity manager
	@Autowired
	private EntityManager entityManager;

	// retrieve all reservations for logged user from database
	@Override
	public Collection<Bilhete> getReservationsByUsuarioId(int userId) {
		
		// create query with HQL to get reservations list
		Query<Bilhete> query = currentSession().createQuery("from Bilhete where reservation_user_id=:userId",
				Bilhete.class);
		query.setParameter("userId", userId);

		return query.getResultList();
	}
	
	// retrieve specific reservation by it's id
	@Override
	public Bilhete getReservationForLoggedUsuarioById(Long resId) {
		
		// create query with HQL to get reservation 
		Query<Bilhete> query = currentSession().createQuery("from Reservation where reservation_id=:resId",
				Bilhete.class);
		query.setParameter("resId", resId);

		return query.getSingleResult();
	}

	// save or update reservation in database
	@Override
	public void saveOrUpdateReservation(Bilhete bilhete) {
		currentSession().saveOrUpdate(bilhete);
	}

	// delete reservation that stored in database
	@Override
	public void deleteReservation(Bilhete bilhete) {
		currentSession().delete(bilhete);
	}

	// get current hibernate session
	private Session currentSession() {
		return entityManager.unwrap(Session.class);
	}

}

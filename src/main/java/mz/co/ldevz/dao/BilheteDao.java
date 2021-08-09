package mz.co.ldevz.dao;

import java.util.Collection;
import mz.co.ldevz.entity.Bilhete;
public interface BilheteDao {
	
	public Bilhete getReservationForLoggedUsuarioById(Long id);

	public Collection<Bilhete> getReservationsByUsuarioId(int userId);
	
	public void saveOrUpdateReservation(Bilhete bilhete);
	
	public void deleteReservation(Bilhete bilhete);

}

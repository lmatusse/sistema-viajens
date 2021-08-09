package mz.co.ldevz.services;

import java.util.Collection;
import mz.co.ldevz.entity.Bilhete;

public interface Bilheteinter {
	public Collection<Bilhete> getReservationsForLoggedUser();
}

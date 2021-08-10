package mz.co.ldevz.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.co.ldevz.entity.Bilhete;
import mz.co.ldevz.entity.Voo;
import mz.co.ldevz.repository.BilheteRepository;
import mz.co.ldevz.repository.UserRep;

@Service
public class BilheteService implements Bilheteinter {

	@Autowired
	private BilheteRepository bilheteRepository;
	
	@Autowired
	private UserRep userRep;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VooService vooService;
	
	@Transactional
	public Bilhete salvar(Bilhete bilhete)
	
	{
		bilhete.setUsuario(userService.getLoggedUserId());
		bilhete.setDataReserva(LocalDate.now());
		return bilheteRepository.save(bilhete);
	}
	
	public Optional<Bilhete> buscar(Long codigo)
	{
		return bilheteRepository.findById(codigo);
	}
	
	public List<Bilhete> listar()
	{
		return bilheteRepository.findAll();
	}
	
	@Transactional
	public void remove(Long codigo)
	{
		bilheteRepository.deleteById(codigo);
	}
	@Override
	@Transactional
	public Collection<Bilhete> getReservationsForLoggedUser() {
		return bilheteRepository.findAllByUsuario((userService.getLoggedUserId()));
	}
}

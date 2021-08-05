package mz.co.ldevz.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.co.ldevz.entity.Aeronave;
import mz.co.ldevz.repository.AeronaveRepository;



@Service
public class AeronaveService 
{
	@Autowired
	private AeronaveRepository aeronaveRepository;
	
	@Transactional
	public Aeronave salvar(Aeronave aeronave)
	{
		return aeronaveRepository.save(aeronave);
	}
	
	public Optional<Aeronave> buscar(Long codigo)
	{
		return aeronaveRepository.findById(codigo);
	}
	
	public List<Aeronave> listar()
	{
		return aeronaveRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		aeronaveRepository.deleteById(codigo);
	}
}

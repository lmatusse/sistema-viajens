package mz.co.ldevz.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.co.ldevz.entity.Perfil;
import mz.co.ldevz.repository.PerfilRepo;

@Service
public class PerfilService {
@Autowired
PerfilRepo perfilRepos;
public List<Perfil> listar()
{
	return perfilRepos.findAll();
}
@Transactional
public Perfil salvar(Perfil perfil)
{
	return perfilRepos.save(perfil);
}
}

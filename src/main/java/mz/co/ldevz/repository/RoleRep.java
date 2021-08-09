package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Perfil;



@Repository
public interface RoleRep extends JpaRepository<Perfil, Integer> {

	Perfil findByName(String roleName);
}

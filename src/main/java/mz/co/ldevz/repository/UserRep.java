package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Usuario;



@Repository
public interface UserRep extends JpaRepository<Usuario, Integer> {

	Usuario findByEmail(String email);
	
	Usuario findByUsername(String username);
}


package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Bilhete;


@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long>{

}

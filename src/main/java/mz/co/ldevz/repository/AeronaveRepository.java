package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Aeronave;



@Repository
public interface AeronaveRepository extends JpaRepository<Aeronave, Long>{

}

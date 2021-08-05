package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Provincia;



@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{

}

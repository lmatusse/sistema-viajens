package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Voo;


@Repository
public interface VooRepository extends JpaRepository<Voo, Long>{

}

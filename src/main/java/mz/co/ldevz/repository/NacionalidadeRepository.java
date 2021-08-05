package mz.co.ldevz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Nacionalidade;



@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long>{

}

package mz.co.ldevz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.CompanhiaAerea;


@Repository
public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Long>{
	@Query(value="Select * from companhia_aerea ca where ca.nome like %:nome%", nativeQuery=true)
	List<CompanhiaAerea> findCaByName(@Param("nome")String nome);
}

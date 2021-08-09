package mz.co.ldevz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.co.ldevz.entity.Voo;


@Repository
public interface VooRepository extends JpaRepository<Voo, Long>{
	@Query(value="Select * from voo v join voopro vp join provincia p "
			+ " where v.codigo=vp.codigo_voo and vp.codigo_provincia=p.codigo and p.nome like %:nome%", nativeQuery=true)
	List<Voo> findCaByName(@Param("nome")String nome);
}

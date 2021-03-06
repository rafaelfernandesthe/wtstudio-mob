package br.com.doutorti.willsalon.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.doutorti.willsalon.model.ProcedureEntity;

public interface IProcedureRepository extends JpaRepository<ProcedureEntity, Long> {

	@Query("select c from ProcedureEntity c where upper(c.name) like upper(concat('%',?1,'%'))")
	List<ProcedureEntity> findByNameContaining(String query);

	@Query("select c from ProcedureEntity c where c.name = ?1")
	List<ProcedureEntity> findByNameEquals(String query);

	@Query("select c from ProcedureEntity c where c.active = 1")
	List<ProcedureEntity> findAllActivies();

	@Query("select c from ProcedureEntity c where c.active = 1 and c.administrative = 0")
	List<ProcedureEntity> findAllActiviesAndNotAdministrative();

	@Query("select c.minutesPrevision from ProcedureEntity c where c.id = ?1")
	Long findMinutesByProcedure(Long id);

}

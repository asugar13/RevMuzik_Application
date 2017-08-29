package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.company.model.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
	
	@Query("SELECT s FROM Show s WHERE s.idshow = :idshow")
	Show findByIdShow(@Param("idshow") Long idshow);
	

}

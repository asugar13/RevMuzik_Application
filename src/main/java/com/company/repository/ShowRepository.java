package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.company.model.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
	
	@Query("SELECT s FROM Show s WHERE s.idshow = :idshow")
	Show findByIdShow(@Param("idshow") Long idshow);
	
	@Query(value = "SELECT * FROM shows s WHERE s.idvenue in(SELECT v.idvenue FROM show_venue v WHERE v.idvenue in (:idsvenues))", nativeQuery = true)
	List<Show> findShowsbyVenues(@Param("idsvenues") List<Long> idsvenues);
	
	@Query(value = "SELECT * FROM shows s WHERE s.idartist in(SELECT a.idartist FROM show_artist a WHERE a.idartist = :idartist)", nativeQuery = true)
	List<Show> findShowsbyArtist(@Param("idartist") Long idartist);

}

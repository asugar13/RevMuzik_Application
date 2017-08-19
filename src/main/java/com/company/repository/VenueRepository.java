package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.company.model.entities.Venue;

/**
 * 
 * @author Eliane Netto
 *
 */
public interface VenueRepository extends JpaRepository<Venue, Long>{
	
	@Query("SELECT v FROM Venue v WHERE v.idvenue = :idvenue AND v.enable = true")
	Venue findByIdVenue(@Param("idvenue") Long idvenue);
	
	@Query("SELECT v FROM Venue v WHERE v.enable = true")
	List<Venue> findVenues();
}

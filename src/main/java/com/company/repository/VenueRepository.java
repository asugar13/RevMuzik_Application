package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.model.entities.Show;
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
	
	@Query("SELECT v FROM Venue v WHERE v.cc_fips = :cc_fips")
	List<Venue> findVenuesByCity(@Param("cc_fips") Long cc_fips);
	
	@Query(value = "SELECT s.idvenue FROM Venue WHERE s.idvenue in(SELECT v.idvenue FROM venue_worldcities WHERE v.cc_fips =:'cc_fips')", nativeQuery = true)
	List<Long> findVenuesIdByCity(@Param("idCity") String cc_fips);
	
}

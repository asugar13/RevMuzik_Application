package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.model.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
	
	@Query("SELECT v FROM Artist v WHERE v.idartist = :idartist AND v.enable = true")
	Artist findByIdArtist(@Param("idvenue") Long idartist);
	
	@Query("SELECT v FROM Artist v WHERE v.enable = true")
	List<Artist> findArtist();	
}


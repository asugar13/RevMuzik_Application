package com.company.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.model.entities.Artist;;

public interface ArtistResource {
	
	ResponseEntity<List<Artist>> list();

	ResponseEntity<Artist> get(Long id);
	
	ResponseEntity<Artist> create(Artist artist);

	ResponseEntity<Artist> update(Artist artist);

	ResponseEntity<Artist> delete(Long id);

}

package com.company.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.model.entities.Venue;

public interface VenueResource {
	
	ResponseEntity<List<Venue>> list();

	ResponseEntity<Venue> get(Long id);
	
	ResponseEntity<Venue> create(Venue venue);

	ResponseEntity<Venue> update(Venue venue);
	
	ResponseEntity<Venue> delete(Long id);
	

}

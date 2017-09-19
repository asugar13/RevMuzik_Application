package com.company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.company.model.entities.Venue;

public interface VenueService {
	
	List<Venue> list();

	Venue get(Long id);
	
	Venue insert(Venue venue);

	Venue update(Venue venue);
	
	Venue updatePassword(Venue venue);

	Venue delete(Long id);

	Page<Venue> findAllByPage(int page, Sort.Direction direction);	
	
	List<Long> venuesByCity(String idCity);

}

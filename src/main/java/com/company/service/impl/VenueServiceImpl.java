package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.model.entities.User;
import com.company.model.entities.Venue;
import com.company.repository.VenueRepository;
import com.company.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueRepository repository;
	
	@Override
	public List<Venue> list() {
		return repository.findAll();
	}

	@Override
	public Venue get(Long id) {
		return repository.findOne( id );
	}

	@Override
	public Venue insert(Venue venue) {
		return repository.save( venue );
	}

	@Override
	public Venue update(Venue venue) {
		Venue persisted = repository.findOne(venue.getIdvenue());

		if (null == persisted)
			return null;
		
		persisted.setCapacity( venue.getCapacity());
		persisted.setDescription( venue.getDescription());
		persisted.setPhoneNumber(venue.getPhoneNumber());
		persisted.setLocation(venue.getLocation());
		persisted.setCc_fips( venue.getCc_fips() );

		return repository.save(persisted);
	}


	@Override
	public Venue delete(Long id) {
		Venue persisted = repository.findOne( id );

		if (null == persisted)
			return null;
		
		repository.delete( persisted );
		return persisted;
	}

	@Override
	public Page<Venue> findAllByPage(int page, Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Long> venuesByCity(String idCity) {
		return repository.findVenuesIdByCity(idCity);
	}
	
}

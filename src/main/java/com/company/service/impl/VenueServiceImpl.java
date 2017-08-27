package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue update(Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue updatePassword(Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Venue> findAllByPage(int page, Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

}

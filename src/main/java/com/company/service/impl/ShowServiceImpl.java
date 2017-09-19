package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.model.entities.Show;
import com.company.repository.ShowRepository;
import com.company.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	private ShowRepository repository;
	
	@Override
	public List<Show> list() {
		return repository.findAll();
	}

	@Override
	public Show get(Long id) {
		return repository.findOne( id );
	}

	@Override
	public Show insert(Show show) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Show update(Show Show) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Show delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Show> findAllByPage(int page, Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Show> showsByVenues(List<Long> idsVenues) {
		return repository.findShowsbyVenues(idsVenues);
	}

	@Override
	public Show getShowByLocationGenreArtistVenue(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

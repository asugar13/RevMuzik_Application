package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.entities.Genre;
import com.company.repository.GenreRepository;
import com.company.service.GenreService;


@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;

	@Override
	public List<Genre> list() {
		return repository.findAll();
	}

	@Override
	public Genre get(Long id) {
		return get(id);
	}

	@Transactional
	@Override
	public Genre insert(Genre genre) {
		return repository.save(genre);
	}

	@Transactional
	@Override
	public Genre update(Genre genre) {
		Genre persisted = repository.findOne( genre.getIdgenre() );

		if (null == persisted)
			return null;
		
		persisted.setDescription( genre.getDescription());

		return repository.save(persisted);
	}
	
	@Transactional
	@Override
	public Genre delete(Long id) {
		Genre persisted = repository.findOne( id );

		if (null == persisted)
			return null;
		
		repository.delete( persisted );
		return persisted;
	}	

}

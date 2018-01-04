package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.model.entities.Artist;
import com.company.model.entities.Venue;
import com.company.repository.ArtistRepository;
import com.company.service.ArtistService;

public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistRepository repository;
	
	@Override
	public List<Artist> list() {
		return repository.findAll();
	}

	@Override
	public Artist get(Long id) {
		return repository.findOne( id );
	}

	@Override
	public Artist insert(Artist artist) {
		return repository.save( artist );
	}

	@Override
	public Artist update(Artist artist) {
		Artist persisted = repository.findOne(artist.getIdartist());

		if (null == persisted)
			return null;
		
		persisted.setArtistUrl(artist.getArtistUrl());
		persisted.setSocialMedia(artist.getSocialMedia());
		persisted.setSong(artist.getSong());
		persisted.setUser(artist.getUser());
		persisted.setEnable(artist.isEnable());
		
		return repository.save(persisted);
	}

	@Override
	public Artist delete(Long id) {
		Artist persisted = repository.findOne( id );

		if (null == persisted)
			return null;
		
		repository.delete( persisted );
		return persisted;
	}

}

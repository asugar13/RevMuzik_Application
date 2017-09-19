package com.company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.company.model.entities.Show;

public interface ShowService {
	
	List<Show> list();

	Show get(Long id);
	
	Show getShowByLocationGenreArtistVenue(Long id);
	
	Show insert(Show Show);

	Show update(Show Show);

	Show delete(Long id);

	Page<Show> findAllByPage(int page, Sort.Direction direction);

	List<Show> showsByVenues(List<Long> cc_fips);	

}

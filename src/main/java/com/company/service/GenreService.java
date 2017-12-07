package com.company.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.company.model.entities.Genre;


public interface GenreService {

	List<Genre> list();

	Genre get(Long id);
	
	Genre insert(Genre user);

	Genre update(Genre user);
	
	Genre delete(Long id);

	Page<Genre> findAllByPage(int page, int limit, String order, Sort.Direction direction);
		

}

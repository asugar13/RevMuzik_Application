package com.company.service;


import java.util.List;
import com.company.model.entities.Genre;


public interface GenreService {

	List<Genre> list();

	Genre get(Long id);
	
	Genre insert(Genre user);

	Genre update(Genre user);
	
	Genre delete(Long id);	

}

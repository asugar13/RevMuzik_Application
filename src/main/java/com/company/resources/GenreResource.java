package com.company.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.company.model.entities.Genre;

/**
 * The Show Resource Interface.
 *
 */
public interface GenreResource {

	ResponseEntity<List<Genre>> list();

	ResponseEntity<Genre> get(Long id);
	
	ResponseEntity<Genre> create(Genre genre);

	ResponseEntity<Genre> update(Genre genre);

	ResponseEntity<Genre> delete(Long id);

}

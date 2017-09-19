package com.company.resources;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.company.model.entities.Show;

public interface ShowResource {
	
	ResponseEntity<List<Show>> list();

	ResponseEntity<Show> get(Long id);
	
	ResponseEntity<Show> create(Show show);

	ResponseEntity<Show> update(Show show);

	ResponseEntity<Show> delete(Long id);
	
	ResponseEntity<List<Show>> showsByCity(Long cc_fips);

}

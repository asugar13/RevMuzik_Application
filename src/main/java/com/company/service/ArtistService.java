package com.company.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import com.company.model.entities.Artist;

public interface ArtistService {
	
	List<Artist> list();

	Artist get(Long id);
	
	Artist insert(Artist artist);

	Artist update(Artist artist);

	Artist delete(Long id);

	Page<Artist> findAllByPage(int page, Sort.Direction direction);
}

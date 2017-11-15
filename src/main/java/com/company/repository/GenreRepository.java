package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.model.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	@Query(value = "SELECT * FROM Genre g WHERE g.idgenre in "+
									" ( SELECT ug.idgenre FROM user_genre ug "+
									"  WHERE ug.iduser = ?1 )", nativeQuery = true)
    List<Genre> findListGenreById(Long id);

}

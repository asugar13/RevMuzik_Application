package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.model.entities.Genre;
import com.company.model.entities.User;

/**
 * The User Repository.
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/*String Q_GET_USER_BY_ID = " SELECT u FROM User u "+
			" left join profile p on u.idprofile = p.idprofile "+
			" left join type_user tp on u.idtype_user = tp.idtype_user "+
			" left join user_genre ug on u.iduser = ug.iduser "+
			" where u.iduser = :id AND u.enable = true ";*/
	
	
	@Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.enable = true")
	User findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE u.iduser = :id AND u.enable = true")
	User findByIdUser(@Param("id") Long id);
	
	/*@Query(Q_GET_USER_BY_ID)
	List<User> findGenrebyIdUser(@Param("id") Long id);*/
	
}

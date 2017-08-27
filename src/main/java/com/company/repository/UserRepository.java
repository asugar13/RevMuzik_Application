package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.model.entities.User;

/**
 * The User Repository.
 * 
 * 
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.enable = true")
	User findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE u.iduser = :id AND u.enable = true")
	User findByIdUser(@Param("id") Long id);
	
}

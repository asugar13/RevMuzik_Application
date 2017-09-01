package com.company.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.company.model.entities.User;

/**
 * The Show Resource Interface.
 *
 */
public interface UserResource {

	ResponseEntity<List<User>> list();

	ResponseEntity<User> get(Long id);
	
	ResponseEntity<User> create(User user);

	ResponseEntity<User> update(User user);
	
	ResponseEntity<User> updatePassword(User user);

	ResponseEntity<User> delete(Long id);

}

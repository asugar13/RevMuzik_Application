package com.company.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.company.model.entities.User;


public interface UserService {
	
	User login(String email, String password);
	
	boolean userCanAccessThisShow(Long id);
	
	List<User> list();

	User get(Long id);
	
	User insert(User user);

	User update(User user);
	
	User updatePassword(User user);

	User delete(Long id);

	Page<User> findAllByPage(int page, int limit, String order, Sort.Direction direction);	

}

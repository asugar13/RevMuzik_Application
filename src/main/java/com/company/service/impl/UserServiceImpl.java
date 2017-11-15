package com.company.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.entities.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import com.company.model.entities.Artist;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User login(String email, String password) {
		return null;
	}

	@Override
	public boolean userCanAccessThisShow(Long showId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = (String)authentication.getPrincipal(); 
		User user = repository.findByEmail( email );
		if ( user != null ) {
			//Iterator<Artist> showIterator = user.getArtist().iterator();
			Iterator<Artist> showIterator  = null;
			while ( showIterator.hasNext() ) {
				if ( showIterator.next().getIdartist().equals( showId ) ) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<User> list() {
		return repository.findAll();
	}

	@Override
	public User get(Long id) {
	   User user = repository.findOne(id);
	   return user;
	}

	@Transactional
	@Override
	public User insert(User user) {
		return repository.save(user);
	}

	@Transactional
	@Override
	public User update(User user) {
		User persisted = repository.findOne( user.getId() );

		if (null == persisted)
			return null;
		
		persisted.setUserName( user.getUserName());
		persisted.setUserFirstName( user.getUserFirstName());
		persisted.setUserLastName(user.getUserLastName());
		persisted.setEnable( user.isEnable() );

		return repository.save(persisted);
	}

	@Transactional
	@Override
	public User updatePassword(User user) {
		User persisted = repository.findOne( user.getId() );

		if (null == persisted)
			return null;
		
		persisted.setUserPassword( user.getUserPassword());

		return repository.save(persisted);
	}
	
	
	@Transactional
	@Override
	public User delete(Long id) {
		User persisted = repository.findOne( id );

		if (null == persisted)
			return null;
		
		repository.delete( persisted );
		return persisted;
	}

	@Override
	public Page<User> findAllByPage(int page, int limit, String order, Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

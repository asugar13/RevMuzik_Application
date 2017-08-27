package com.company.resources.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.entities.User;
import com.company.resources.UserResource;
import com.company.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/v1/users", tags = { "user" })
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserResourceImpl implements UserResource {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value = "Retrieves a list of users", tags = { "user" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of users", responseContainer = "List", response = User.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		
		List<User> users = service.list();

		if (users.isEmpty())
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@ApiOperation(value = "Get a user by id", tags = { "user" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a user searched by id", response = User.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> get(@ApiParam(value = "User Id", required = true) @PathVariable("id") Long id) {
		
		User user = service.get(id);

		if (null == user)
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a user resource", tags = { "user" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created user resource", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no user was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<User> create(@ApiParam(value = "User json stream resource", required = true) @Valid @RequestBody User user) {
		User created = service.insert(user);

		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<User>(created, HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Update a user resource", tags = { "user" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated user resource", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@ApiParam(value = "User json stream resource", required = true) @RequestBody User user) {
		
		User persisted = service.update(user);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(persisted, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a password of user resource", tags = { "user" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated user resource", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	public ResponseEntity<User> updatePassword(@ApiParam(value = "User json stream resource", required = true) @Valid @RequestBody User user) {
		
		User persisted = service.update(user);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(persisted, HttpStatus.OK);
	}	
	
	@ApiOperation(value = "Delete a user resource", tags = { "user" }, code = 204)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content retrieve, deleted user resource", response = User.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no delete was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@ApiParam(value = "User Id", required = true) @PathVariable("id") Long id) {
		User persisted = service.delete(id);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	

}

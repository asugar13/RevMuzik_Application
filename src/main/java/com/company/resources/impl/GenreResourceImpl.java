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

import com.company.model.entities.Genre;
import com.company.resources.GenreResource;
import com.company.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/v1/genres", tags = { "genre" })
@RestController
@RequestMapping(value = "/api/v1/genre")
public class GenreResourceImpl implements GenreResource {
	
	@Autowired
	private GenreService service;
	
	@ApiOperation(value = "Retrieves a list of genres", tags = { "genre" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of genres", responseContainer = "List", response = Genre.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Genre>> list() {
		
		List<Genre> genres = service.list();

		if (genres.isEmpty())
			return new ResponseEntity<List<Genre>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
	}

	@ApiOperation(value = "Get a genre by id", tags = { "genre" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a genre searched by id", response = Genre.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Genre> get(@ApiParam(value = "Genre Id", required = true) @PathVariable("id") Long id) {
		
		Genre genre = service.get(id);

		if (null == genre)
			return new ResponseEntity<Genre>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Genre>(genre, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update a genre resource", tags = { "genre" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created genre resource", response = Genre.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no genre was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Genre> create(@ApiParam(value = "Genre json stream resource", required = true, name = "genre") @Valid @RequestBody Genre genre) {
		
		Genre created = service.insert(genre);

		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<Genre>(created, HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Update a genre resource", tags = { "genre" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated genre resource", response = Genre.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Genre> update(@ApiParam(value = "Genre json stream resource", required = true) @RequestBody Genre genre) {
		
		Genre persisted = service.update(genre);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Genre>(persisted, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete a genre resource", tags = { "genre" }, code = 204)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content retrieve, deleted genre resource", response = Genre.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no delete was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Genre> delete(@ApiParam(value = "Genre Id", required = true) @PathVariable("id") Long id) {
		
		Genre persisted = service.delete(id);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	

}

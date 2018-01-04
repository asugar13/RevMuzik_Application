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

import com.company.model.entities.Artist;
import com.company.resources.ArtistResource;
import com.company.service.ArtistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/v1/artists", tags = { "artist" })
@RestController
@RequestMapping(value = "/api/v1/artist")
public class ArtistResourceImpl implements ArtistResource{

	@Autowired
	private ArtistService service;
	
	@ApiOperation(value = "Retrieves a list of artist", tags = { "artist" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of artist", responseContainer = "List", response = Artist.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Artist>> list() {	
		List<Artist> artist = service.list();
		if (artist.isEmpty())
			return new ResponseEntity<List<Artist>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Artist>>(artist, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get a artist by id", tags = { "artist" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a artist searched by id", response = Artist.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Artist> get(@ApiParam(value = "artist Id", required = true) @PathVariable("id") Long id) {
    	 Artist artist = service.get(id);
		 if (null == artist)
			return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Artist>(artist, HttpStatus.OK);
	}


	@ApiOperation(value = "Create a artist resource", tags = { "artist" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created artist resource", response = Artist.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no artist was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Artist> create(@ApiParam(value = "artist json stream resource", required = true, name = "artist") @Valid @RequestBody Artist artist) {
		Artist created = service.insert(artist);
		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<Artist>(created, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update a artist resource", tags = { "artist" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated artist resource", response = Artist.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Artist> update(@ApiParam(value = "artist json stream resource", required = true) @RequestBody Artist artist) {
		Artist persisted = service.update(artist);
		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Artist>(persisted, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a artist resource", tags = { "artist" }, code = 204)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content retrieve, deleted Artist resource", response = Artist.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no delete was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Artist> delete(@ApiParam(value = "Artist Id", required = true) @PathVariable("id") Long id) {	
		Artist persisted = service.delete(id);
		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	

}

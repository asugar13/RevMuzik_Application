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

import com.company.model.entities.Venue;
import com.company.resources.VenueResource;
import com.company.service.VenueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/v1/venues", tags = { "venue" })
@RestController
@RequestMapping(value = "/api/v1/venue")
public class VenueResourceImpl implements VenueResource {
	
	@Autowired
	private VenueService service;
	
	@ApiOperation(value = "Retrieves a list of venues", tags = { "venue" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of venues", responseContainer = "List", response = Venue.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Venue>> list() {
		
		List<Venue> venues = service.list();
		
		if (venues.isEmpty())
			return new ResponseEntity<List<Venue>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Venue>>(venues, HttpStatus.OK);
	}

	@ApiOperation(value = "Get a venue by id", tags = { "venue" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a venue searched by id", response = Venue.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venue> get(@ApiParam(value = "Veuen Id", required = true) @PathVariable("id") Long id) {
		 Venue venue = service.get(id);

		if (null == venue)
			return new ResponseEntity<Venue>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Venue>(venue, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a venues resource", tags = { "venue" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created venue resource", response = Venue.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no venue was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Venue> create(@ApiParam(value = "Venue json stream resource", required = true, name = "venue") @Valid @RequestBody Venue venue) {
		
		Venue created = service.insert(venue);

		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<Venue>(created, HttpStatus.CREATED);
	}

	
	@ApiOperation(value = "Update a venue resource", tags = { "venue" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve an updated venue resource", response = Venue.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no update was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Venue> update(@ApiParam(value = "Venue json stream resource", required = true) @RequestBody Venue venue) {
		
		Venue persisted = service.update(venue);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Venue>(persisted, HttpStatus.OK);
	}


	@ApiOperation(value = "Delete a venue resource", tags = { "venue" }, code = 204)
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content retrieve, deleted venue resource", response = Venue.class),
			@ApiResponse(code = 404, message = "Not found retrieve if no delete was process", response = Void.class) })
	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Venue> delete(@ApiParam(value = "Venue Id", required = true) @PathVariable("id") Long id) {
		
		Venue persisted = service.delete(id);

		if (null == persisted)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
}

package com.company.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.entities.User;
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
			@ApiResponse(code = 200, message = "Retrieve a venue searched by id", response = User.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venue> get(@ApiParam(value = "Veuen Id", required = true) @PathVariable("id") Long id) {
		 Venue venue = service.get(id);

		if (null == venue)
			return new ResponseEntity<Venue>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Venue>(venue, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Venue> create(Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Venue> update(Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Venue> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

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

import com.company.model.entities.Show;
import com.company.resources.ShowResource;
import com.company.service.ShowService;
import com.company.service.VenueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/api/v1/shows", tags = { "show" })
@RestController
@RequestMapping(value = "/api/v1/show")
public class ShowResourceImpl implements ShowResource{
	
	@Autowired
	private ShowService service;
	@Autowired
	private VenueService serviceVenue;
	
	@ApiOperation(value = "Retrieves entire list of shows", tags = { "show" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieves a list of gigs", responseContainer = "List", response = Show.class),
			@ApiResponse(code = 204, message = "No content retrieve", responseContainer = "List", response = Void.class) })
	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Show>> list() {
		
		List<Show> shows = service.list();

		if (shows.isEmpty())
			return new ResponseEntity<List<Show>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
	}
	

	@ApiOperation(value = "Get a shows by id", tags = { "show" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a show searched by id", response = Show.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by id", response = Void.class) })
	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Show> get(@ApiParam(value = "Show Id", required = true) @PathVariable("id") Long id) {
		Show show = service.get(id);

		if (null == show)
			return new ResponseEntity<Show>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Show>(show, HttpStatus.OK);
	}

	@ApiOperation(value = "Get a shows by locationid", tags = { "showsByCity" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retrieve a show searched by locationid", response = Show.class),
			@ApiResponse(code = 204, message = "No content retrieve searched by locationid", response = Void.class) })
	@Override
	@RequestMapping(value = "/city/{cc_fips}", method = RequestMethod.GET)
	public ResponseEntity<List<Show>> showsByCity(@ApiParam(value = "City Id", required = true) @PathVariable("cc_fips") String cc_fips) {	
		List<Long> venuesId = serviceVenue.venuesByCity(String.valueOf(cc_fips));//idcidade
		List<Show> shows = service.showsByVenues(venuesId);//idcidade
		if (null == shows)
			return new ResponseEntity<List<Show>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Show>>(shows, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a user resource", tags = { "show" }, code = 200)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Retrieve a created user resource", response = Show.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class),
			@ApiResponse(code = 304, message = "Not modified retrieve if no user was created", response = Void.class) })
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Show> create(@ApiParam(value = "User json stream resource", required = true) @Valid @RequestBody Show show) {
		Show created = service.insert(show);

		if (null == created)
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<Show>(created, HttpStatus.CREATED);
	}
	

	@Override
	public ResponseEntity<Show> update(Show show) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Show> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

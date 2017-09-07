package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the shows database table.
 * 
 */
@Entity
@Table(name="shows")
@NamedQuery(name="Show.findAll", query="SELECT s FROM Show s")
public class Show implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idshow;

	@Column(name = "description")	
	private String description;
	
	@Column(name = "name")	
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date_time")
	private Date endDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date_time")
	private Date startDateTime;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "show_artist", 
		joinColumns = {
			@JoinColumn(name = "idshow", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "idartist", nullable = false, updatable = false) })	
	private Set<Artist> artist;	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "show_venue", 
		joinColumns = {
			@JoinColumn(name = "idshow", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "idvenue", nullable = false, updatable = false) })	
	private Set<Venue> venue;	

	public Show() {
	}

	
	public Long getIdshow() {
		return idshow;
	}


	public void setIdshow(Long idshow) {
		this.idshow = idshow;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Set<Artist> getArtist() {
		return artist;
	}

	public void setArtist(Set<Artist> artist) {
		this.artist = artist;
	}

	public Set<Venue> getVenue() {
		return venue;
	}
	
	public void setVenue(Set<Venue> venue) {
		this.venue = venue;
	}
	
}
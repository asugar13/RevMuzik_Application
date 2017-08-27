package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idvenue", nullable = false)	
	private Venue venue;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idartist", nullable = false)	
	private Artist artist;

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


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}
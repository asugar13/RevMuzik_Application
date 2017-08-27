package com.company.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idsong;

	@Column(name="name_song")
	private String namesong;

	@Column(name="url")
	private String url;
	

	@Column(name="artist_origin")
	private String artistOrigin;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgenre", nullable = false)	
	private Genre genre;
	

	public Song() {
	}

	public Long getIdsong() {
		return idsong;
	}

	public void setIdsong(Long idsong) {
		this.idsong = idsong;
	}

	
	public String getNamesong() {
		return namesong;
	}

	public void setNamesong(String namesong) {
		this.namesong = namesong;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getArtistOrigin() {
		return artistOrigin;
	}

	public void setArtistOrigin(String artistOrigin) {
		this.artistOrigin = artistOrigin;
	}
	
}
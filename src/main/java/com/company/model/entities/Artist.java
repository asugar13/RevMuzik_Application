package com.company.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Artist")
public class Artist implements Serializable{

	
	private static final long serialVersionUID = -7497379530223277900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idartist;
	
	@Column(name="artist_url")
	private String artistUrl;


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "artist_user", 
		joinColumns = {
			@JoinColumn(name = "idartist", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "iduser", nullable = false, updatable = false) })	
	private Set<User> user;	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "artist_song", 
		joinColumns = {
			@JoinColumn(name = "idartist", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "idsong", nullable = false, updatable = false) })	
	private Set<Song> song;	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsocial_media", nullable = false)	
	private SocialMedia socialMedia;
	
	public Artist() {

	}
	
	public Long getIdartist() {
		return idartist;
	}

	public void setIdartist(Long idartist) {
		this.idartist = idartist;
	}

	public String getArtistUrl() {
		return artistUrl;
	}

	public void setArtistUrl(String artistUrl) {
		this.artistUrl = artistUrl;
	}


	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Set<Song> getSong() {
		return song;
	}

	public void setSong(Set<Song> song) {
		this.song = song;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}

	
}

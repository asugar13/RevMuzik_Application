package com.company.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the social_media database table.
 * 
 */
@Entity
@Table(name="social_media")
@NamedQuery(name="SocialMedia.findAll", query="SELECT s FROM SocialMedia s")
public class SocialMedia implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idsocial_media")
	private Long idsocial_media;

	@Column(name="name_social_media")
	private String nameSocialMedia;

	@Column(name="url_social_media")
	private String urlSocialMedia;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socialMedia")
	private List<Venue> venue;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socialMedia")
	private List<Artist> artist;
	

	public SocialMedia() {
	}

	public Long getIdsocialMedia() {
		return idsocial_media;
	}

	public void setIdsocialMedia(Long idsocialMedia) {
		this.idsocial_media = idsocialMedia;
	}

	public String getNameSocialMedia() {
		return this.nameSocialMedia;
	}

	public void setNameSocialMedia(String nameSocialMedia) {
		this.nameSocialMedia = nameSocialMedia;
	}

	public String getUrlSocialMedia() {
		return this.urlSocialMedia;
	}

	public void setUrlSocialMedia(String urlSocialMedia) {
		this.urlSocialMedia = urlSocialMedia;
	}

	public List<Venue> getVenue() {
		return venue;
	}

	public void setVenue(List<Venue> venue) {
		this.venue = venue;
	}

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}

	

	

}
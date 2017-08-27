package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the venue database table.
 * 
 */
@Entity
@NamedQuery(name="Venue.findAll", query="SELECT v FROM Venue v")
public class Venue implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idvenue;
	
	@Column(name="capacity")
	private int capacity;

	@Column(name="description")
	private String description;

	@Column(name="email")
	private String email;

	@Column(name="equipments")
	private String equipments;

	@Column(name="hours")
	private String hours;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="picture_url")
	private String pictureUrl;

	@Column(name="idstyle")
	private Long idStyle;
	
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	public boolean enable;

	@Column(name="url")
	private String url;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venue")
	private List<Show> show;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "venue_user", 
		joinColumns = {
			@JoinColumn(name = "idvenue", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "iduser", nullable = false, updatable = false) })	
	private Set<User> user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsocial_media", nullable = false)	
	private SocialMedia socialMedia;

	public Venue() {
	}

	public Long getIdvenue() {
		return this.idvenue;
	}

	public void setIdvenue(Long idvenue) {
		this.idvenue = idvenue;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEquipments() {
		return this.equipments;
	}

	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}

	public String getHours() {
		return this.hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}


	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Long getStyleId() {
		return this.idStyle;
	}

	public void setStyleId(Long styleId) {
		this.idStyle = styleId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Long getIdStyle() {
		return idStyle;
	}

	public void setIdStyle(Long idStyle) {
		this.idStyle = idStyle;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}


	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public SocialMedia getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}


}
package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.math.BigInteger;


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

	private int capacity;

	private String description;

	private String email;

	private String equipments;

	private String hours;

	@Column(name="idtype_user")
	private Long idtypeUser;

	private Long iduser;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="picture_url")
	private String pictureUrl;

	@Column(name="idstyle")
	private Long idStyle;
	
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	public boolean enable;

	private String url;

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

	public Long getIdtypeUser() {
		return this.idtypeUser;
	}

	public void setIdtypeUser(Long idtypeUser) {
		this.idtypeUser = idtypeUser;
	}

	public Long getIduser() {
		return this.iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
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


}
package com.company.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="authority")
public class Authority implements Serializable {

	private static final long serialVersionUID = -2407509206628191822L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idauthority;
	
	@NotNull
	private String name;
		
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	private boolean enable;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idprofile", nullable = false)	
	private Profile profile;
		
	public Integer getId() {
		return idauthority;
	}

	public void setId(Integer id) {
		this.idauthority = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}

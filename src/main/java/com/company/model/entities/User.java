package com.company.model.entities;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.company.model.entities.Profile;
import com.company.model.entities.Show;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -7497379530223277900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iduser;
	
	@NotNull
	private String user_email;

	private String user_first_name;

	private String user_last_name;

	@NotNull
	private String user_name;

	@NotNull
	private String user_password;
	
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	public boolean enable;
	
	//@OneToOne
	//private Profile profile;
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idprofile", nullable = false)	
	private Profile profile;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Show> shows;
	
	//add /bi-directional many-to-many association to SocialMedi Genre Media
	
	public Long getId() {
		return iduser;
	}

	public void setId(Long id) {
		this.iduser = id;
	}

	public String getUserEmail() {
		return user_email;
	}

	public void setUserEmail(String userEmail) {
		this.user_email = userEmail;
	}

	public String getUserFirstName() {
		return user_first_name;
	}

	public void setUserFirstName(String userFirstName) {
		this.user_first_name = userFirstName;
	}

	public String getUserLastName() {
		return user_last_name;
	}

	public void setUserLastName(String userLastName) {
		this.user_last_name = userLastName;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public String getUserPassword() {
		return user_password;
	}

	public void setUserPassword(String userPassword) {
		this.user_password = userPassword;
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

	public Set<Show> getShows() {
		return shows;
	}

	public void setShows(Set<Show> shows) {
		this.shows = shows;
	}

}

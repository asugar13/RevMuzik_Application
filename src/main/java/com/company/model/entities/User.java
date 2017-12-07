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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -7497379530223277900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iduser;
	
	@NotNull
	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_first_name")
	private String userFirstName;

	@Column(name="user_last_name")
	private String userLastName;

	@NotNull
	@Column(name="user_name")
	private String userName;

	@NotNull
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	public boolean enable;
	
	//@JsonIgnore
	@OneToOne
	@JoinColumn(name = "idprofile", nullable = false)
	private Profile profile;
	
	//@JsonIgnore
	@OneToOne
	@JoinColumn(name = "idtype_user", nullable = false)
	private TypeUser typeuser;

	@ManyToMany
	@JoinTable(name = "user_genre", 
				joinColumns = {@JoinColumn(name = "iduser", referencedColumnName="iduser") },
				inverseJoinColumns = {@JoinColumn(name = "idgenre", referencedColumnName="idgenre") })	
	private List<Genre> genre;	

	//add /bi-directional many-to-many association to SocialMedi Genre Media
	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public TypeUser getTypeuser() {
		return typeuser;
	}

	public void setTypeuser(TypeUser typeuser) {
		this.typeuser = typeuser;
	}


	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}

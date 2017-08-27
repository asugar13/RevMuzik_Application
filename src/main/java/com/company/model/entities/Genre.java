package com.company.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idgenre;

	@Column(name="description")
	private String description;

	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
	private List<Song> song;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genre")
	private List<User> user;
	
	
	public Genre() {
	}

	public Long getIdgenre() {
		return this.idgenre;
	}

	public void setIdgenre(Long idgenre) {
		this.idgenre = idgenre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
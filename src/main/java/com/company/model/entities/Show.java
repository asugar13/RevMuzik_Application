package com.company.model.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shows")
public class Show implements Serializable {
	
	private static final long serialVersionUID = 5307205810414341804L;

	@Id
	private Long idshows;
		
	@Size(min = 1, max = 60)	
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "shows_users", 
		joinColumns = {
			@JoinColumn(name = "show_id", nullable = false, updatable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "user_id", nullable = false, updatable = false) })	
	private Set<User> users;
	
	public Show() {
		
	}
	
	public Show(Long id, String name) {
		this.idshows = id;
		this.name = name;
	}

	public Long getId() {
		return idshows;
	}

	public void setId(Long id) {
		this.idshows = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}

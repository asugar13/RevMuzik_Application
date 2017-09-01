package com.company.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 3939281142231716049L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idprofile;
	
	@NotNull
	private String name;
		
	@Column(name = "enable", columnDefinition = "BIT", length = 1)
	@Type(type="yes_no")
	public boolean enable;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
	private List<Authority> authorities;

	public Integer getId() {
		return idprofile;
	}

	public void setId(Integer id) {
		this.idprofile = id;
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

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}

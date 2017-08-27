package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the type_user database table.
 * 
 */
@Entity
@Table(name="type_user")
@NamedQuery(name="TypeUser.findAll", query="SELECT t FROM TypeUser t")
public class TypeUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idtypeUser;

	@NotNull
	@Column(name="description")
	private String description;

	public TypeUser() {
	}

	public Long getIdtypeUser() {
		return idtypeUser;
	}

	public void setIdtypeUser(Long idtypeUser) {
		this.idtypeUser = idtypeUser;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
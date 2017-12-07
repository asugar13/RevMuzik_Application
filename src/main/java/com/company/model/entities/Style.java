package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the style database table.
 * 
 */
@Entity
@NamedQuery(name="Style.findAll", query="SELECT s FROM Style s")
public class Style implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idstyle;

	private String description;

	public Style() {
	}

	public Long getIdstyle() {
		return idstyle;
	}

	public void setIdstyle(Long idstyle) {
		this.idstyle = idstyle;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
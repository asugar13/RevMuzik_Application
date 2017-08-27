package com.company.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the meta database table.
 * 
 */
@Entity
@NamedQuery(name="Meta.findAll", query="SELECT m FROM Meta m")
public class Meta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idmeta;

	private Long idstyle;

	@Column(name="picture_url")
	private String pictureUrl;

	@Column(name="similar_artist")
	private String similarArtist;

	private String url;

	public Meta() {
	}

	public Long getIdmeta() {
		return idmeta;
	}

	public void setIdmeta(Long idmeta) {
		this.idmeta = idmeta;
	}

	public Long getIdstyle() {
		return this.idstyle;
	}

	public void setIdstyle(Long idstyle) {
		this.idstyle = idstyle;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getSimilarArtist() {
		return this.similarArtist;
	}

	public void setSimilarArtist(String similarArtist) {
		this.similarArtist = similarArtist;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
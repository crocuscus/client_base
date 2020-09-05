package com.clientbase.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the legal_client database table.
 * 
 */
@Entity
@Table(name="legal_client")
@NamedQuery(name="LegalClient.findAll", query="SELECT l FROM LegalClient l")
public class LegalClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="short_name")
	private String shortName;

	private String tin;

	@Id
	@Column(name="client_id")
	private Integer clientId;

	public LegalClient() {
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTin() {
		return this.tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
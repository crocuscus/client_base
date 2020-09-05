package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the individual_client database table.
 * 
 */
@Entity
@Table(name="individual_client")
@NamedQuery(name="IndividualClient.findAll", query="SELECT i FROM IndividualClient i")
public class IndividualClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;

	private String passport;

	@Temporal(TemporalType.DATE)
	@Column(name="passport_date")
	private Date passportDate;

	@Column(name="passport_from_whom")
	private String passportFromWhom;

	@Column(name="second_name")
	private String secondName;

	private String surname;

	//bi-directional many-to-one association to Client
	@Id
	@Column(name="client_id")
	private Integer clientId;

	public IndividualClient() {
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getPassportDate() {
		return this.passportDate;
	}

	public void setPassportDate(Date passportDate) {
		this.passportDate = passportDate;
	}

	public String getPassportFromWhom() {
		return this.passportFromWhom;
	}

	public void setPassportFromWhom(String passportFromWhom) {
		this.passportFromWhom = passportFromWhom;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
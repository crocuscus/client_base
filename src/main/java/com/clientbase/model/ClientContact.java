package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_contact database table.
 * 
 */
@Entity
@Table(name="client_contact")
@NamedQuery(name="ClientContact.findAll", query="SELECT c FROM ClientContact c")
public class ClientContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="contact_name")
	private String contactName;

	private String email;

	private String phone;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	public ClientContact() {
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
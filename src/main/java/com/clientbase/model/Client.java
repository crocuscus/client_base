package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id")
	private Integer Id;

	@Column(name="client_type")
	private Boolean clientType;

	//bi-directional many-to-one association to ClientContact
	@OneToMany(mappedBy="client")
	private List<ClientContact> clientContacts;

	//bi-directional many-to-one association to IndividualClient
	@OneToMany(mappedBy="client")
	private List<IndividualClient> individualClients;

	//bi-directional many-to-one association to LegalClient
	@OneToMany(mappedBy="client")
	private List<LegalClient> legalClients;

	//bi-directional many-to-one association to OrderHistory
	@OneToMany(mappedBy="client")
	private List<OrderHistory> orderHistories;

	public Client() {
	}

	public Integer getClientId() {
		return this.Id;
	}

	public void setClientId(Integer clientId) {
		this.Id = clientId;
	}

	public Boolean getClientType() {
		return this.clientType;
	}

	public void setClientType(Boolean clientType) {
		this.clientType = clientType;
	}

//	public List<ClientContact> getClientContacts() {
//		return this.clientContacts;
//	}
//
//	public void setClientContacts(List<ClientContact> clientContacts) {
//		this.clientContacts = clientContacts;
//	}
//
//	public ClientContact addClientContact(ClientContact clientContact) {
//		getClientContacts().add(clientContact);
//		clientContact.setClient(this);
//
//		return clientContact;
//	}
//
//	public ClientContact removeClientContact(ClientContact clientContact) {
//		getClientContacts().remove(clientContact);
//		clientContact.setClient(null);
//
//		return clientContact;
//	}
//
//	public List<IndividualClient> getIndividualClients() {
//		return this.individualClients;
//	}
//
//	public void setIndividualClients(List<IndividualClient> individualClients) {
//		this.individualClients = individualClients;
//	}
//
//	public IndividualClient addIndividualClient(IndividualClient individualClient) {
//		getIndividualClients().add(individualClient);
//		individualClient.setClient(this);
//
//		return individualClient;
//	}
//
//	public IndividualClient removeIndividualClient(IndividualClient individualClient) {
//		getIndividualClients().remove(individualClient);
//		individualClient.setClient(null);
//
//		return individualClient;
//	}
//
//	public List<LegalClient> getLegalClients() {
//		return this.legalClients;
//	}
//
//	public void setLegalClients(List<LegalClient> legalClients) {
//		this.legalClients = legalClients;
//	}
//
//	public LegalClient addLegalClient(LegalClient legalClient) {
//		getLegalClients().add(legalClient);
//		legalClient.setClient(this);
//
//		return legalClient;
//	}
//
//	public LegalClient removeLegalClient(LegalClient legalClient) {
//		getLegalClients().remove(legalClient);
//		legalClient.setClient(null);
//
//		return legalClient;
//	}
//
//	public List<OrderHistory> getOrderHistories() {
//		return this.orderHistories;
//	}
//
//	public void setOrderHistories(List<OrderHistory> orderHistories) {
//		this.orderHistories = orderHistories;
//	}
//
//	public OrderHistory addOrderHistory(OrderHistory orderHistory) {
//		getOrderHistories().add(orderHistory);
//		orderHistory.setClient(this);
//
//		return orderHistory;
//	}
//
//	public OrderHistory removeOrderHistory(OrderHistory orderHistory) {
//		getOrderHistories().remove(orderHistory);
//		orderHistory.setClient(null);
//
//		return orderHistory;
//	}

}
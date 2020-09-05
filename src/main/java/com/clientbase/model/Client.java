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
	@SequenceGenerator(name = "Client_ID_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="Client_ID_seq")
	@Column(name="client_id")
	private Integer clientId;

	@Column(name="client_type")
	private Boolean clientType;

	private String fullname;

	 //bi-directional many-to-one association to ClientContact
	 @OneToMany(mappedBy="client") 
	 private List<ClientContact> clientContacts;
	 
//	 //bi-directional many-to-one association to IndividualClient
//	 @OneToOne(mappedBy="client") 
//	 private IndividualClient individualClient;
//	 //bi-directional many-to-one association to LegalClient
//	 @OneToOne(mappedBy="client") 
//	 private LegalClient legalClient;

	 //bi-directional many-to-one association to OrderHistory
	 @OneToMany(mappedBy="client")
	 private List<OrderHistory> orderHistories;

	public Client() {
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Boolean getClientType() {
		return this.clientType;
	}

	public void setClientType(Boolean clientType) {
		this.clientType = clientType;
	}
	
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<ClientContact> getClientContacts() {
		return this.clientContacts;
	}

	public void setClientContacts(List<ClientContact> clientContacts) {
		this.clientContacts = clientContacts;
	}

	public ClientContact addClientContact(ClientContact clientContact) {
		getClientContacts().add(clientContact);
		clientContact.setClient(this);

		return clientContact;
	}

	public ClientContact removeClientContact(ClientContact clientContact) {
		getClientContacts().remove(clientContact);
		clientContact.setClient(null);

		return clientContact;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + clientId;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (clientId != other.clientId)
			return false;
		return true;
	}
 
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
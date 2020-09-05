package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order_history database table.
 * 
 */
@Entity
@Table(name="order_history")
@NamedQuery(name="OrderHistory.findAll", query="SELECT o FROM OrderHistory o")
public class OrderHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OrderHistory_ID_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="OrderHistory_ID_seq")
	@Column(name="order_id")
	private Integer orderId;

	@Column(name="from_dttm")
	private Timestamp fromDttm;

	@Column(name="to_dttm")
	private Timestamp toDttm;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_id")
	private Service service;

	//bi-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="workload"
		, joinColumns={
			@JoinColumn(name="order_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="employee_id")
			}
		)
	private List<Employee> employees;

	public OrderHistory() {
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Timestamp getFromDttm() {
		return this.fromDttm;
	}

	public void setFromDttm(Timestamp fromDttm) {
		this.fromDttm = fromDttm;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

//	public List<Employee> getEmployees() {
//		return this.employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}

}
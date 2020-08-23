package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="service_id")
	private Integer serviceId;

	@Column(name="prescence_flag")
	private Boolean prescenceFlag;

	private double price;

	@Column(name="service_name")
	private String serviceName;

	//bi-directional many-to-one association to OrderHistory
	@OneToMany(mappedBy="service")
	private List<OrderHistory> orderHistories;

	public Service() {
	}

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Boolean getPrescenceFlag() {
		return this.prescenceFlag;
	}

	public void setPrescenceFlag(Boolean prescenceFlag) {
		this.prescenceFlag = prescenceFlag;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

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
//		orderHistory.setService(this);
//
//		return orderHistory;
//	}
//
//	public OrderHistory removeOrderHistory(OrderHistory orderHistory) {
//		getOrderHistories().remove(orderHistory);
//		orderHistory.setService(null);
//
//		return orderHistory;
//	}

}
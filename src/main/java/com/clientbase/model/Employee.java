	package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "Employee_ID_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="Employee_ID_seq")
	@Column(name="employee_id")
	private Integer employeeId;

	private String address;

	private String education;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String passport;

	@Temporal(TemporalType.DATE)
	@Column(name="passport_date")
	private Date passportDate;

	@Column(name="passport_from_whom")
	private String passportFromWhom;

	private String phone;

	private String post;

	@Column(name="second_name")
	private String secondName;

	private String surname;

	//bi-directional many-to-one association to EmployeeStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private EmployeeStatus employeeStatus;

	//bi-directional many-to-many association to OrderHistory
	@ManyToMany(mappedBy="employees")
	private List<OrderHistory> orderHistories;

	public Employee() {
	}

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void	 setFirstName(String firstName) {
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
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

	public EmployeeStatus getEmployeeStatus() {
		return this.employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

//	public List<OrderHistory> getOrderHistories() {
//		return this.orderHistories;
//	}
//
//	public void setOrderHistories(List<OrderHistory> orderHistories) {
//		this.orderHistories = orderHistories;
//	}

}
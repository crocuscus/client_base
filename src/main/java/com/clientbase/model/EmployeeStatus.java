package com.clientbase.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_status database table.
 * 
 */
@Entity
@Table(name="employee_status")
@NamedQuery(name="EmployeeStatus.findAll", query="SELECT e FROM EmployeeStatus e")
public class EmployeeStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EmployeeStatus_ID_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="EmployeeStatus_ID_seq")
	@Column(name="status_id")
	private Short statusId;

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employeeStatus")
	private List<Employee> employees;

	public EmployeeStatus() {
	}

	public Short getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Short statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

//	public List<Employee> getEmployees() {
//		return this.employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//
//	public Employee addEmployee(Employee employee) {
//		getEmployees().add(employee);
//		employee.setEmployeeStatus(this);
//
//		return employee;
//	}
//
//	public Employee removeEmployee(Employee employee) {
//		getEmployees().remove(employee);
//		employee.setEmployeeStatus(null);
//
//		return employee;
//	}

}
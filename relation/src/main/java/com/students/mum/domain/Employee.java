package com.students.mum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@NamedQuery(query = "select e from Employee e where e.number like :number", name = "Employee.locateOneEmployeeByHisNumber")
@Data
public class Employee {
	@Id
	@GeneratedValue(generator="employeeGen")
	private Integer id;

	private String firstName;

	private String lastName;

	private String number;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	private Address address;

}

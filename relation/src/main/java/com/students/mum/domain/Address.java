package com.students.mum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(generator="addressGen")
	private Integer id;
	private String line1;
	private String line2;

	private String city;
	private String state;
	private String country;
	private String zipcode;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_xx_id", nullable = false)
	private Employee employee;

}

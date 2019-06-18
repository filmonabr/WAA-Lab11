package com.students.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.students.mum.domain.Address;
import com.students.mum.domain.Employee;
import com.students.mum.service.RelationService;

@Controller
public class RelationController {

	@Autowired
	private RelationService relationService;

	@RequestMapping("/emp/find")
	@ResponseBody
	public Iterable<Employee> getEmployeeByNumber(@RequestParam("number") String num) {
		return relationService.getEmployeeByNumber(num);
	}

	@GetMapping("/emp")
//	@ResponseStatus(HttpStatus.CREATED)
	public String empForm(@ModelAttribute("employee") Employee emp) {
		return "EmployeeForm";
	}

	@PostMapping("/emp")
	@ResponseStatus(HttpStatus.CREATED)
	public String getEmployeeByNumber(@Valid Employee emp) {
		emp.setAddress(new Address());
		emp.getAddress().setEmployee(emp);
		relationService.saveEmployee(emp);
		return "EmployeeDetails";
	}
}

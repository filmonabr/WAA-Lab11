package com.students.mum.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.mum.domain.Employee;
import com.students.mum.repository.EmployeeRepository;

@Service
@Transactional
public class RelationService {
	@Autowired
	private EmployeeRepository EmployeeRepository;

	public Iterable<Employee> getEmployeeByNumber(String num) {
		return EmployeeRepository.locateOneEmployeeByHisNumber("%" + num + "%");
	}

	public void saveEmployee(Employee emp) {
		emp.getAddress().setEmployee(emp);
		EmployeeRepository.save(emp);
	}
}

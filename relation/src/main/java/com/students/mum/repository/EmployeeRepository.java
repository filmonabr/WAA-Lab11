package com.students.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.students.mum.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Iterable<Employee> locateOneEmployeeByHisNumber(@Param("number") String number);
}

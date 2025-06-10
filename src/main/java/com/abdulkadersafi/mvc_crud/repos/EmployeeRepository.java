package com.abdulkadersafi.mvc_crud.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.abdulkadersafi.mvc_crud.entities.Employee;

@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}

// /employees
// Sort by first name
// /employees?sort=firstName,desc
// Sort by last name then first name
// /employees?sort=lastName,firstName,asc

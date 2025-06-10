package com.abdulkadersafi.mvc_crud.services;

import java.util.List;
import java.util.Optional;

import com.abdulkadersafi.mvc_crud.entities.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(int id);

    void delete(int id);

}

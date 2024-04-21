package com.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.learning.entity.Employee;

public interface EmpRepository  extends CrudRepository<Employee, Integer>{

}

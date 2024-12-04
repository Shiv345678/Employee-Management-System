package com.Shivangi.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shivangi.Project.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}

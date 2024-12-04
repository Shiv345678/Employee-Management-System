package com.Shivangi.Project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shivangi.Project.Entity.Employee;
import com.Shivangi.Project.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee Created in database";
		
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emplist = new ArrayList<>();
		employeeRepository.findAll().forEach(emplist::add);
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployeeById(@PathVariable long id,@RequestBody Employee employee) {
		Optional<Employee> emp =  employeeRepository.findById(id);
		if(emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setEmp_age(employee.getEmp_age());
			existEmp.setEmp_city(employee.getEmp_city());
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_Salary(employee.getEmp_Salary());
			employeeRepository.save(existEmp);
			return "Employee Details against Id " + id + " updated";
		}
		else {
			return "Employee Details Does not Exist for Id " + id;
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable long id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted Successfully";
	}
	
	@DeleteMapping("/employees")
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "Employee deleted Successfully";
	}
	
}

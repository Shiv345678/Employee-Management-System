package com.Shivangi.Project.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Employee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="emp_Salary")
	private Float emp_Salary;
	
	@Column(name="emp_age")
	private int emp_age;
	
	@Column(name="emp_city")
	private String emp_city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Float getEmp_Salary() {
		return emp_Salary;
	}

	public void setEmp_Salary(Float emp_Salary) {
		this.emp_Salary = emp_Salary;
	}

	public int getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	public Employee(Long id, String emp_name, Float emp_Salary, int emp_age, String emp_city) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.emp_Salary = emp_Salary;
		this.emp_age = emp_age;
		this.emp_city = emp_city;
	}
	
	public Employee(){
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", emp_Salary=" + emp_Salary + ", emp_age=" + emp_age
				+ ", emp_city=" + emp_city + "]";
	}
	
}

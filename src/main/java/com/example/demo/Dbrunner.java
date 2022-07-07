package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.DepartmentRepo;
import com.example.demo.repo.EmployeeRepo;

public class Dbrunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private DepartmentRepo depRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome to DataBase");
//		saveEmployeeOneToMany();
//		saveEmployeeManyToOne();
		getEmployeeData();
	}
//	public void saveEmployeeOneToMany() {
//		Employee emp1 = new Employee(1,"karnan","mallavi");
//		Employee emp2 = new Employee(2,"ricky","vavuniya");
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(emp1);
//		empList.add(emp2);
//		Department dep1 = new Department(1,"ICT",empList);
//		depRepo.save(dep1);
//		System.out.println("DEp SAVED");	
//	}
	public void getDepartmentData() {
		
	}
	
//	public void saveEmployeeManyToOne() {
//		Department dep1 = new Department(1,"ICT");
//		Employee emp1 = new Employee(1,"karnan","mallavi",dep1);
//		empRepo.save(emp1);
//		Employee emp2 = new Employee(2,"ricky","vavuniya",dep1);
//		empRepo.save(emp2);
//		System.out.println("Employee SAVED");	
//	}
	public void getEmployeeData() {
		System.out.println("Employee Records");
		System.out.println(empRepo.findAll());
	}

}

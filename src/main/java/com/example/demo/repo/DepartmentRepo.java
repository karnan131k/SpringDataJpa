package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

	public Department findByDepartmentName(String departmentName);
}

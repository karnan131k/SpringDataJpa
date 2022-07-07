package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="DEPARTMENT_ID",referencedColumnName="DEPARTMENT_ID",nullable = false)
//	private List<Employee> employee;
	
}

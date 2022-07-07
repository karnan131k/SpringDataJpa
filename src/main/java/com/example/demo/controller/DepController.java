package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.DepartmentBinding;
import com.example.demo.binding.EmployeeBinding;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.DepartmentRepo;
import com.example.demo.repo.EmployeeRepo;

@RestController
@RequestMapping("/")
public class DepController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private DepartmentRepo depRepo;
	
	@PostMapping("department")
	public ResponseEntity<String> saveDepartment(@RequestBody DepartmentBinding data){
		Department dep = new Department();
		BeanUtils.copyProperties(data,dep);
		depRepo.save(dep);
		return new ResponseEntity<>("saved",HttpStatus.CREATED);
	}
	
	@PostMapping("employee")
	public ResponseEntity<String> savedEmployee(@RequestBody EmployeeBinding empdata){
		Optional<Department> depData = depRepo.findById(empdata.getDepartmentId());
		Employee emp= new Employee();
		BeanUtils.copyProperties(empdata,emp);
		emp.setDepartment(depData.get());
		empRepo.save(emp);
		return new ResponseEntity<>("saved",HttpStatus.CREATED);
	}
	
	@GetMapping("employee")
	public ResponseEntity<List<Employee>> getEmploee(){
		
		return new ResponseEntity<>(empRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("department")
	public ResponseEntity<List<Department>> getDepartment(){
		return new ResponseEntity<>(depRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("department/{departmentName}")
	public ResponseEntity<List<Employee>> getEmployeeByDepartmentName(@PathVariable("departmentName") String departmentName){
		Department depData= depRepo.findByDepartmentName(departmentName);
		List<Employee>  empData = empRepo.findByDepartment(depData);
		return new ResponseEntity<>(empData,HttpStatus.OK);
	}
}

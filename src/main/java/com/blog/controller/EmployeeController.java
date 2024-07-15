package com.blog.controller;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.blog.model.*;
import com.blog.service.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empsrvice;
	
	@GetMapping("")
	public ResponseEntity<?> getAllEmp(){
		Collection<Employee> all_emp=empsrvice.getAllEmployee();
		if(all_emp.size()==0) {
			return new ResponseEntity<>("No Record Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(all_emp,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getById(@PathVariable int id){
		Employee employee=empsrvice.getById(id);
		if(employee == null) {
//			return new ResponseEntity<>("Invalid ID",HttpStatus.NOT_FOUND);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid ID");
		}
		return new ResponseEntity<>(employee,HttpStatus.FOUND);
	}
	
	@PostMapping("")
	public ResponseEntity<?>createEmp(@Valid @RequestBody Employee emp){
		empsrvice.create(emp);
		return new ResponseEntity<>("New Record Created",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateemp(@Valid @PathVariable int id,@RequestBody Employee emp){
		Employee employee=empsrvice.getById(id);
		if(employee == null) {
//			return new ResponseEntity<>("Invalid ID",HttpStatus.NOT_FOUND);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid ID");
			
		}
		empsrvice.update(id, emp);
		return new ResponseEntity<>("Record Updated",HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteemp(@PathVariable int id){
		Employee employee=empsrvice.getById(id);
		if(employee == null) {
//			return new ResponseEntity<>("Invalid ID",HttpStatus.NOT_FOUND);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid ID");
		}
		empsrvice.delete(id);
		return new ResponseEntity<>("Record Deleted",HttpStatus.OK);
	}
}

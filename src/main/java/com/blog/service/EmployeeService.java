package com.blog.service;

import com.blog.controller.*;
import com.blog.model.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private static HashMap<Integer,Employee> empmap=new HashMap<Integer,Employee>();
	private static AtomicInteger atomicintger=new AtomicInteger();

	
	public Collection<Employee> getAllEmployee(){
		return empmap.values();
	}
	
	public Employee getById(int id){
		return empmap.get(id);
	}
	
	public void create(Employee employee) {
		employee.setId(atomicintger.incrementAndGet());
		empmap.put(employee.getId(), employee);
	}
	
	public void update(int id,Employee employee) {
		employee.setId(id);
		empmap.put(id, employee);
	}
	public void delete(int id) {
		empmap.remove(id);
	}
	
}

package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.model.Employee1;
import com.service.EmployeeService;

@RestController
@RequestMapping(path="/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	@GetMapping(path="/getEmployees")
	public ResponseEntity<List<Employee1>> getEmployees()
	{
		List<Employee1> le=empservice.getEmps();
		
		ResponseEntity re=new ResponseEntity<List<Employee1>>(le,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getEmployee/{eid}")
	public ResponseEntity<Employee1> getEmpById(@PathVariable int eid)
	{
	 Optional<Employee1> e1=empservice.getEmpById(eid);
		
		ResponseEntity re=new ResponseEntity<Employee1>(HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addEmployee")
	public ResponseEntity<Employee1> addEmployee(@RequestBody Employee1 e)
	{
		Employee1 e1=empservice.createEmp(e);
		
		ResponseEntity re=new ResponseEntity<Employee1>(e1,HttpStatus.OK);
		return re;
	}
	@PostMapping(path="/addEmployees")
	public ResponseEntity<List<Employee1>> addEmployees(@RequestBody List<Employee1> ls)
	{
		List<Employee1> le=empservice.addEmps(ls);
		
		ResponseEntity re=new ResponseEntity<List<Employee1>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateEmployee")
	public ResponseEntity<Employee1> updateEmployee(@RequestBody Employee1 e) throws Exception
	{
		Employee1 e1=empservice.updateEmp(e);
		
		ResponseEntity re=new ResponseEntity<Employee1>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestBody Employee1 e)
	{
		empservice.deleteEmp(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteEmployee/{eid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int eid)
	{
		empservice.deleteEmpById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	@GetMapping(
	        path = {"/getEmpTech/{tech}"}
	    )
	    public ResponseEntity<List<Employee1>> getEmpbyTech(@PathVariable String tech) {
	        List<Employee1> le = empservice.getempBytechSorted(tech);
	        ResponseEntity re = new ResponseEntity(le, HttpStatus.OK);
	        return re;
	    }
	
	}
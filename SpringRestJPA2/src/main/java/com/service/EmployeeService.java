package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Employee1;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {

	List<Employee1> le;

	@Autowired(required = true)
	EmployeeRepository erepo;

	public EmployeeService() {
	}

	public List<Employee1> getEmps() {
		le = new ArrayList<>();
		le = erepo.findAll();
		return le;
	}

	
	  public Optional<Employee1> getEmpById(int eid)
	  {
		  String tech="JAVA";
		  Optional <Employee1> e1=erepo.findById(eid);
		  List<Employee1> e2=erepo.findByTech(tech);
		  System.out.println(e2); 
		  return e1; 
		  }
	 

	public Employee1 createEmp(Employee1 e) {
		Employee1 e1 = erepo.save(e);
		return e1;
	}

	public List<Employee1> addEmps(List<Employee1> ls) {
		le = new ArrayList<>();
		le = erepo.saveAll(ls);
		return le;
	}

	public Employee1 updateEmp(Employee1 e) throws Exception {
		int id = e.getEid();
		Supplier<Exception> s1 = () -> new ResourceNotFoundException("Employee id is not present in the database");
		Employee1 e1 = erepo.findById(id).orElseThrow(s1);

		e1.setEname(e.getEname());
		e1.setTech(e.getTech());
		erepo.save(e1);
		return e1;
	}

	public String deleteEmp(Employee1 e) {
		erepo.delete(e);
		return "Deleted";
	}

	public String deleteEmpById(int eid) {
		// Employee e=erepo.findById(eid).orElse(null);
		erepo.deleteById(eid);
		return "Deleted";
	}

	public List<Employee1> getempBytechSorted(String tech) {
		List<Employee1> ls = erepo.findByTechSorted(tech);
		System.out.println(ls);
		return ls;
	}

}
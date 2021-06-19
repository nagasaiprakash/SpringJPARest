package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.model.Employee1;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee1, Integer>
{

	List<Employee1> findByTech(String tech);
	
	  @Query("Select e from Employee1 e order by e.ename")
	   List<Employee1> findByTechSorted(String tech);
	
	

}
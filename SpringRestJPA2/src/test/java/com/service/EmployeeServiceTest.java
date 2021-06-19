
package com.service;

import com.model.Employee1;
import com.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    EmployeeService empservice;
    @MockBean
    EmployeeRepository emprepo;

    EmployeeServiceTest() {
    }

    @Test
    void testGetEmps() {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Employee1 e2 = new Employee1();
        e2.setEid(2);
        e2.setEname("Madhuri");
        e2.setTech("Java");
        List<Employee1> empList = new ArrayList();
        empList.add(e1);
        empList.add(e2);
        Mockito.when(this.emprepo.findAll()).thenReturn(empList);
        Assertions.assertThat(this.empservice.getEmps()).isEqualTo(empList);
    }

    @Test
    void testGetEmpById() {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Optional<Employee1> e2 = Optional.of(e1);
        Mockito.when(this.emprepo.findById(1)).thenReturn(e2);
        Assertions.assertThat(this.empservice.getEmpById(1)).isEqualTo(e2);
    }

    @Test
    void testCreateEmp() {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Mockito.when((Employee1)this.emprepo.save(e1)).thenReturn(e1);
        Assertions.assertThat(this.empservice.createEmp(e1)).isEqualTo(e1);
    }

    @Test
    void testAddEmps() {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Employee1 e2 = new Employee1();
        e2.setEid(2);
        e2.setEname("Madhuri");
        e2.setTech("Java");
        List<Employee1> empList = new ArrayList();
        empList.add(e1);
        empList.add(e2);
        Mockito.when(this.emprepo.saveAll(empList)).thenReturn(empList);
        Assertions.assertThat(this.empservice.addEmps(empList)).isEqualTo(empList);
    }

    @Test
    void testUpdateEmp() throws Exception {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Optional<Employee1> e2 = Optional.of(e1);
        Mockito.when(this.emprepo.findById(1)).thenReturn(e2);
        e1.setEname("Madhulika");
        Mockito.when((Employee1)this.emprepo.save(e1)).thenReturn(e1);
        Assertions.assertThat(this.empservice.updateEmp(e1)).isEqualTo(e1);
    }

    @Test
    void testDeleteEmp() {
        Employee1 e1 = new Employee1();
        e1.setEid(1);
        e1.setEname("Madhu");
        e1.setTech("JavaFS");
        Optional<Employee1> e2 = Optional.of(e1);
        Mockito.when(this.emprepo.findById(1)).thenReturn(e2);
        Mockito.when(this.emprepo.existsById(e1.getEid())).thenReturn(false);
        org.junit.jupiter.api.Assertions.assertFalse(this.emprepo.existsById(e1.getEid()));
    }
}

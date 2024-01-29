package com.example.spring.web.rest;

import com.example.spring.domain.Employee;
import com.example.spring.domain.request.ReqEmployee;
import com.example.spring.service.impl.EmployeeServiceImpl;
import com.example.spring.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqEmployee reqEmployee){
        String response = employeeService.createEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqEmployee reqEmployee){
        String response = employeeService.updateEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Employee> employees = employeeService.all();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/all")
    public ResponseEntity<?> filter(){
        List<Employee> employees = employeeService.getAllByFilter();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id){
        Employee employees = employeeService.byId(id);
        return ResponseEntity.ok(employees);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }
}

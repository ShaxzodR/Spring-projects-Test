package com.example.spring.web.rest;

import com.example.spring.domain.Company;
import com.example.spring.domain.Employee;
import com.example.spring.domain.enumation.Position;
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
    public ResponseEntity<?> create(@RequestBody ReqEmployee reqEmployee) {
        String response = employeeService.createEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqEmployee reqEmployee) {
        String response = employeeService.updateEmployee(reqEmployee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        List<Employee> employees = employeeService.all();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filter(@RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName,
                                    @RequestParam(required = false) Position position,
                                    @RequestParam(required = false) String yearOfBirth,
                                    @RequestParam(required = false)Company company) {
        List<Employee> employeeList = employeeService.filter(firstName, lastName, position, yearOfBirth,company);
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id) {
        Employee employees = employeeService.byId(id);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/inActive/{id}")
    public ResponseEntity<?> inActiveStatus(@PathVariable Long id) {
        employeeService.inActiveStatus(id);
        return ResponseEntity.ok("Holat faol holatga o'tkazilmadi");
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<?> ActiveStatus(@PathVariable Long id) {
        employeeService.ActivateStatus(id);
        return ResponseEntity.ok("Holat faol holatga o'tkazildi");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }
}

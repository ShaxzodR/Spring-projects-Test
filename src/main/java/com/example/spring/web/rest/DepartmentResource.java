package com.example.spring.web.rest;

import com.example.spring.domain.Department;
import com.example.spring.domain.request.ReqDepartment;
import com.example.spring.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentResource {
    private final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqDepartment reqCompany){
        String response = departmentService.createDepartment(reqCompany);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqDepartment reqCompany){
        String response = departmentService.updateDepartment(reqCompany);
        System.out.println("Text");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Department> companies = departmentService.getAllDepartment();
        return ResponseEntity.ok(companies);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> byId(@PathVariable long id){
       Department company =  departmentService.findByDepartmentId(id);
       return ResponseEntity.ok(company);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }

}

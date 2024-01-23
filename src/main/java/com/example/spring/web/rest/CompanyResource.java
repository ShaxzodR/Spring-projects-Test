package com.example.spring.web.rest;

import com.example.spring.domain.Company;
import com.example.spring.domain.request.ReqCompany;
import com.example.spring.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyResource {
    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqCompany reqCompany){
        String response = companyService.createCompany(reqCompany);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqCompany reqCompany){
        String response = companyService.updateCompany(reqCompany);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Company> companies = companyService.getAllCompany();
        return ResponseEntity.ok(companies);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> byId(@PathVariable long id){
       Company company =  companyService.findByCompanyId(id);
       return ResponseEntity.ok(company);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        companyService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }

}

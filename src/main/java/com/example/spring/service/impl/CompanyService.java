package com.example.spring.service.impl;

import com.example.spring.domain.Company;
import com.example.spring.domain.request.ReqCompany;
import com.example.spring.repository.AreaRep;
import com.example.spring.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AreaRep areaRep;

    public CompanyService(CompanyRepository companyRepository, AreaRep areaRep) {
        this.companyRepository = companyRepository;
        this.areaRep = areaRep;
    }


    public String createCompany(ReqCompany reqCompany) {
        try {
            Company company = new Company();
            company.setId(reqCompany.getId());
            company.setName(reqCompany.getName());
            company.setArea(areaRep.getReferenceById(reqCompany.getAreaId()));
            companyRepository.save(company);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateCompany(ReqCompany reqCompany) {
        try {
            Company company = new Company();
            company.setId(reqCompany.getId());
            company.setName(reqCompany.getName());
            company.setArea(areaRep.getReferenceById(reqCompany.getAreaId()));
            companyRepository.save(company);
            return "Muvoffaqiyatli uzgartirildi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Company> getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    public Company findByCompanyId(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            Company company1 = company.get();
            return company1;
        } else {
            return new Company();
        }
    }

    public void delete(long id) {
        Company company = companyRepository.getReferenceById(id);
        companyRepository.delete(company);
    }

}

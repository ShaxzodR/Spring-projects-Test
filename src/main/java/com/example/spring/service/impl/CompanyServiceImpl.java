package com.example.spring.service.impl;

import com.example.spring.domain.Company;
import com.example.spring.domain.request.ReqCompany;
import com.example.spring.repository.AreaRepositry;
import com.example.spring.repository.CompanyRepository;
import com.example.spring.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final AreaRepositry areaRep;

    public CompanyServiceImpl(CompanyRepository companyRepository, AreaRepositry areaRep) {
        this.companyRepository = companyRepository;
        this.areaRep = areaRep;
    }


    public String createCompany(ReqCompany reqCompany) {
        try {
            Company company = new Company();
            company.setId(reqCompany.getId());
            company.setName(reqCompany.getName());
            company.setArea(areaRep.findById(reqCompany.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area with ID " + reqCompany.getAreaId() + " not found")));
            companyRepository.save(company);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateCompany(ReqCompany reqCompany) {
        try {
            if (reqCompany.getAreaId() != null) {
                if (companyRepository.findById(reqCompany.getAreaId()).isPresent()) {
                    Company currentCompany = companyRepository.findById(reqCompany.getId()).get();
                    currentCompany.setId(reqCompany.getId());
                    currentCompany.setName(reqCompany.getName());
                    currentCompany.setArea(areaRep.findById(reqCompany.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area with ID " + reqCompany.getAreaId() + " not found")));
                    companyRepository.save(currentCompany);
                    return "Muvoffaqiyatli uzgartirildi!";
                } else {
                    return " bu id topilmadi";
                }
            } else {
                return " Xatolik bor qaytadan urinib kuring";
            }
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

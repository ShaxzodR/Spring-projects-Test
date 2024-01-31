package com.example.spring.service;

import com.example.spring.domain.Company;
import com.example.spring.domain.request.ReqCompany;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public String createCompany(ReqCompany reqCompany);

    public String updateCompany(ReqCompany reqCompany);

    public List<Company> getAllCompany();

    public Company findByCompanyId(Long id);

    public void delete(long id);
}

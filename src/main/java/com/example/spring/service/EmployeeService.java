package com.example.spring.service;

import com.example.spring.domain.Employee;
import com.example.spring.domain.request.ReqEmployee;

import java.util.List;

public interface EmployeeService {

    String createEmployee(ReqEmployee reqEmployee);

    String updateEmployee(ReqEmployee reqEmployee);

    List<Employee> all();

    Employee byId(Long id);

    void delete(Long id);

    void inActiveStatus(Long id);

    void ActivateStatus(Long id);

    List<Employee> filter(String type, String searchName);
}

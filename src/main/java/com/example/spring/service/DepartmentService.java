package com.example.spring.service;

import com.example.spring.domain.Department;
import com.example.spring.domain.request.ReqDepartment;

import java.util.List;

public interface DepartmentService {
    public String createDepartment(ReqDepartment reqDepartment);

    public String updateDepartment(ReqDepartment reqDepartment);

    public List<Department> getAllDepartment();

    public Department findByDepartmentId(Long id);

    public void delete(long id);
}

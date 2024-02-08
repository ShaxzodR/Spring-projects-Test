package com.example.spring.service.impl;

import com.example.spring.domain.Department;
import com.example.spring.domain.request.ReqDepartment;
import com.example.spring.repository.AreaRepositry;
import com.example.spring.repository.DepartmentRepository;
import com.example.spring.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final AreaRepositry areaRep;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, AreaRepositry areaRep) {
        this.departmentRepository = departmentRepository;
        this.areaRep = areaRep;
    }


    public String createDepartment(ReqDepartment reqDepartment) {
        try {
            Department department = new Department();
            department.setId(reqDepartment.getId());
            department.setName(reqDepartment.getName());
            department.setArea(areaRep.findById(reqDepartment.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area with ID " + reqDepartment.getAreaId() + " not found")));
            departmentRepository.save(department);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateDepartment(ReqDepartment reqDepartment) {
        try {
            if (reqDepartment.getAreaId() != null) {
                if (departmentRepository.findById(reqDepartment.getAreaId()).isPresent()) {
                    Department currentDepartment = departmentRepository.findById(reqDepartment.getId()).get();
                    currentDepartment.setId(reqDepartment.getId());
                    currentDepartment.setName(reqDepartment.getName());
                    currentDepartment.setArea(areaRep.findById(reqDepartment.getAreaId()).orElseThrow(() -> new EntityNotFoundException("Area with ID " + reqDepartment.getAreaId() + " not found")));
                    departmentRepository.save(currentDepartment);
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

    public List<Department> getAllDepartment() {
        List<Department> getAllDepartment = departmentRepository.findAll();
        return getAllDepartment;
    }

    public Department findByDepartmentId(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department department1 = department.get();
            return department1;
        } else {
            return new Department();
        }
    }

    public void delete(long id) {
        Department department = departmentRepository.getReferenceById(id);
        departmentRepository.delete(department);
    }

}

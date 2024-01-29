package com.example.spring.service.impl;

import com.example.spring.domain.Employee;
import com.example.spring.domain.enumation.Gender;
import com.example.spring.domain.enumation.Position;
import com.example.spring.domain.request.ReqEmployee;
import com.example.spring.repository.CompanyRepository;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.repository.RegionRep;
import com.example.spring.repository.TasksRepository;
import com.example.spring.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final RegionRep regionRep;
    private final TasksRepository tasksRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository, RegionRep regionRep, TasksRepository tasksRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.regionRep = regionRep;
        this.tasksRepository = tasksRepository;
    }

    public String createEmployee(ReqEmployee reqEmployee) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setGender(reqEmployee.getGender() == 1 ? Gender.MALE : reqEmployee.getGender() == 2 ? Gender.FEMALE : Gender.DEFAULT);
            employee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setCompany(companyRepository.findById(reqEmployee.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Kompaniya topilmadi!")));
            if (reqEmployee.getPosition() != null) {
                employee.setPosition(Position.valueOf(reqEmployee.getPosition()));
            } else {
                return "Lavozim kiritish majburiy!";
            }
            employeeRepository.save(employee);
            return "Muvoffaqqiyatli saqlandi";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateEmployee(ReqEmployee reqEmployee) {
        try {
            if (reqEmployee.getId() != null) {
                if (employeeRepository.findById(reqEmployee.getId()).isPresent()) {
                    Employee currentEmployee = employeeRepository.findById(reqEmployee.getId()).get();
                    currentEmployee.setFirstName(reqEmployee.getFirstName());
                    currentEmployee.setLastName(reqEmployee.getLastName());
                    currentEmployee.setGender(reqEmployee.getGender() == 1 ? Gender.MALE : reqEmployee.getGender() == 2 ? Gender.FEMALE : Gender.DEFAULT);
                    if (reqEmployee.getPosition() != null)
                        currentEmployee.setPosition(Position.valueOf(reqEmployee.getPosition()));
                    if (reqEmployee.getCompanyId() != null)
                        currentEmployee.setCompany(companyRepository.findById(reqEmployee.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Kompaniya topilmadi!")));
                    currentEmployee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
                    currentEmployee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
                    currentEmployee.setCompany(companyRepository.getReferenceById(reqEmployee.getCompanyId()));
                    employeeRepository.save(currentEmployee);
                    return "Muvoffaqqiyatli uzgartirildi";
                } else {
                    return "Bunday xodim bazada topilmadi!";
                }
            } else {
                return "Xodim tanlanmadi!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Employee> all() {
        List<Employee> all = employeeRepository.findAll();
        return all;
    }

    public Employee byId(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()) {
            Employee employee = byId.get();
            return employee;
        } else {
            return new Employee();
        }
    }

    public void delete(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(employee);
    }

    public void inActiveStatus(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topilmadi!"));
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public void ActivateStatus(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topilmadi!"));
        employee.setActive(true);
        employeeRepository.save(employee);
    }

    public List<Employee> getAllByFilter() {
        return null;
    }

    //ismi, familiyasi ,tugilgan yili, positsiyasi,kompaniyasi bo'yicha qidiruv
}

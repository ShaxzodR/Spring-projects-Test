package com.example.spring.service;

import com.example.spring.domain.Employee;
import com.example.spring.domain.request.ReqEmployee;
import com.example.spring.repository.CompanyRepository;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.repository.RegionRep;
import com.example.spring.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final RegionRep regionRep;
    private final TasksRepository tasksRepository;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository, RegionRep regionRep, TasksRepository tasksRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.regionRep = regionRep;
        this.tasksRepository = tasksRepository;
    }


    public String createEmployee(ReqEmployee reqEmployee){
        try {
            Employee employee = new Employee();
            employee.setId(reqEmployee.getId());
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setPosition(reqEmployee.getPosition());
            employee.setWorkSchedule(reqEmployee.getWorkSchedule());
            employee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setCompany(companyRepository.getReferenceById(reqEmployee.getCompanyId()));
            employee.setTask(tasksRepository.getReferenceById(reqEmployee.getTaskId()));
            employeeRepository.save(employee);
            return "Muvoffaqqiyatli saqlandi";
        } catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String updateEmployee(ReqEmployee reqEmployee){
        try {
            Employee employee = new Employee();
            employee.setId(reqEmployee.getId());
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setPosition(reqEmployee.getPosition());
            employee.setWorkSchedule(reqEmployee.getWorkSchedule());
            employee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setCompany(companyRepository.getReferenceById(reqEmployee.getCompanyId()));
            employee.setTask(tasksRepository.getReferenceById(reqEmployee.getTaskId()));
            employeeRepository.save(employee);
            return "Muvoffaqqiyatli uzgartirildi";
        } catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public List<Employee> all(){
       List<Employee> all =  employeeRepository.findAll();
       return all;
    }
    public Employee byId(Long id){
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()){
            Employee employee = byId.get();
            return employee;
        } else {
            return new Employee();
        }
    }
    public void delete(Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        employeeRepository.delete(employee);
    }
}

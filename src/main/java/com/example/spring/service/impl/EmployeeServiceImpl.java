package com.example.spring.service.impl;

import com.example.spring.domain.Employee;
import com.example.spring.domain.Task;
import com.example.spring.domain.enumation.Gender;
import com.example.spring.domain.enumation.Position;
import com.example.spring.domain.request.ReqEmployee;
import com.example.spring.repository.DepartmentRepository;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository companyRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }


    public String createEmployee(ReqEmployee reqEmployee) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(reqEmployee.getFirstName());
            employee.setLastName(reqEmployee.getLastName());
            employee.setGender(reqEmployee.getGender() == 1 ? Gender.MALE : reqEmployee.getGender() == 2 ? Gender.FEMALE : Gender.DEFAULT);
            employee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
            employee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
            employee.setDepartment(companyRepository.findById(reqEmployee.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Kompaniya topilmadi!")));
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
                        currentEmployee.setDepartment(companyRepository.findById(reqEmployee.getCompanyId()).orElseThrow(() -> new EntityNotFoundException("Kompaniya topilmadi!")));
                    currentEmployee.setYearOfBirth(String.valueOf(reqEmployee.getYearOfBirth()));
                    currentEmployee.setGraduatedUniversity(reqEmployee.getGraduatedUniversity());
                    currentEmployee.setDepartment(companyRepository.getReferenceById(reqEmployee.getCompanyId()));
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
        return employeeRepository.findAll();
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



    //    public List<Employee> filter(String firstName,
//                                 String lastName,
//                                 Position position,
//                                 String yearOfBirth,
//                                 Department company) {
//        try {
//            if (employeeRepository != null) {
//                if (firstName != null) {
//                    return employeeRepository.findByFirstName(firstName);
//                } else if (lastName != null) {
//                    return employeeRepository.findByLastName(lastName);
//                }else if (position != null){
//                    return employeeRepository.findByPosition(position);
//                } else if (yearOfBirth!=null) {
//                    return employeeRepository.findByYearOfBirth(yearOfBirth);
//                } else if (company !=null) {
//                    return employeeRepository.findByCompany(company);
//                } else {
//                    return Collections.emptyList();
//                }
//            } else {
//                throw new IllegalStateException("Employee repository is not initialized.");
//            }
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
    public List<Employee> filter(String type, String searchName) {
        List<Employee> employeeList = new ArrayList<>();
        if (type.equals("firstName")) {
            employeeList = employeeRepository.findByFirstName(searchName);
        } else if (type.equals("lastName")) {
            employeeList = employeeRepository.findByLastName(searchName);
        } else if (type.equals("age")) {
            employeeList = employeeRepository.findByYearOfBirth(searchName);
        } else if (type.equals("position")) {
            employeeList = employeeRepository.findByPosition(Position.valueOf(searchName));
        }
        return employeeList;
    }


    //ismi, familiyasi ,tugilgan yili, positsiyasi,kompaniyasi bo'yicha qidiruv
}

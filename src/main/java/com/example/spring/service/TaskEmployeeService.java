package com.example.spring.service;

import com.example.spring.domain.TaskEmployee;
import com.example.spring.domain.request.ReqTaskEmployee;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.repository.TaskEmployeeRepository;
import com.example.spring.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskEmployeeService {
    private final TaskEmployeeRepository taskEmployeeRepository;
    private final TasksRepository tasksRepository;
    private final EmployeeRepository employeeRepository;

    public TaskEmployeeService(TaskEmployeeRepository taskEmployeeRepository, TasksRepository tasksRepository, EmployeeRepository employeeRepository) {
        this.taskEmployeeRepository = taskEmployeeRepository;
        this.tasksRepository = tasksRepository;
        this.employeeRepository = employeeRepository;
    }
    public String create(ReqTaskEmployee reqTaskEmployee){
        try {
            TaskEmployee taskEmployee = new TaskEmployee();
            taskEmployee.setId(reqTaskEmployee.getId());
            taskEmployee.setTask(tasksRepository.getReferenceById(reqTaskEmployee.getTaskId()));
            taskEmployee.setEmployee(employeeRepository.getReferenceById(reqTaskEmployee.getEmployeeId()));
            taskEmployeeRepository.save(taskEmployee);
            return "Muvaffaqiyatli saqlandi";
        }catch (Exception e){
            e.printStackTrace();
            return "xatolik";
        }
    }
    public List<TaskEmployee> all(){
        return taskEmployeeRepository.findAll();
    }
}

package com.example.spring.service.impl;

import com.example.spring.domain.Task;
import com.example.spring.domain.enumation.Status;
import com.example.spring.domain.request.ReqTask;
import com.example.spring.repository.EmployeeRepository;
import com.example.spring.repository.TasksRepository;
import com.example.spring.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TasksRepository tasksRepository;
    private final EmployeeRepository employeeRepository;

    public TaskServiceImpl(TasksRepository tasksRepository, EmployeeRepository employeeRepository) {
        this.tasksRepository = tasksRepository;
        this.employeeRepository = employeeRepository;
    }


    public String createTask(ReqTask reqTask){
        try {
            Task tasks = new Task();
            tasks.setTitle(reqTask.getTitle());
            tasks.setText(reqTask.getText());
            tasks.setDeadline(reqTask.getDeadline());
            if (reqTask.getStatus() != null)
                tasks.setStatus(Status.valueOf(reqTask.getStatus()));
            if (reqTask.getEmployee()!= null)
                tasks.setEmployee(employeeRepository.findById(reqTask.getEmployee()).orElseThrow(() -> new EntityNotFoundException(" Ishchi topilmadi")));
            tasks.setCreatedBy(employeeRepository.getReferenceById(reqTask.getCreatedBy()));
            tasks.setUpdatedBy(employeeRepository.getReferenceById(reqTask.getUpdateBy()));
            tasksRepository.save(tasks);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String update(ReqTask reqTask){
        try {
            Task tasks = new Task();
            tasks.setTitle(reqTask.getTitle());
            tasks.setText(reqTask.getText());
            tasks.setDeadline(reqTask.getDeadline());
            if (reqTask.getStatus() != null)
                tasks.setStatus(Status.valueOf(reqTask.getStatus()));
            if (reqTask.getEmployee()!= null)
                tasks.setEmployee(employeeRepository.findById(reqTask.getEmployee()).orElseThrow(() -> new EntityNotFoundException(" Ishchi topilmadi")));
            tasks.setCreatedBy(employeeRepository.findById(reqTask.getCreatedBy()).get());
            tasks.setUpdatedBy(employeeRepository.findById(reqTask.getUpdateBy()).orElseThrow(()-> new EntityNotFoundException( " ")));
            tasksRepository.save(tasks);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e){
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public List<Task> getAllTasks(){
        List<Task> all = tasksRepository.findAll();
        return all;
    }
    public Task getById(Long id){
        Optional<Task> byId = tasksRepository.findById(id);
        if (byId.isPresent()){
            Task tasks = byId.get();
            return tasks;
        }else {
            return new Task();
        }
    }
    public void delate(Long id){
        Task tasks = tasksRepository.getReferenceById(id);
        tasksRepository.delete(tasks);
    }
}

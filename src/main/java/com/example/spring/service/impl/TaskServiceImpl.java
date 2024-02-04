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


    public String createTask(ReqTask reqTask) {
        try {
            Task tasks = new Task();
            tasks.setTitle(reqTask.getTitle());
            tasks.setText(reqTask.getText());
            tasks.setDeadline(reqTask.getDeadline());
            if (reqTask.getStatus() != null)
                tasks.setStatus(Status.valueOf(reqTask.getStatus()));
            if (reqTask.getEmployee() != null)
                tasks.setEmployee(employeeRepository.findById(reqTask.getEmployee()).orElseThrow(() -> new EntityNotFoundException(" Ishchi topilmadi")));
            if (reqTask.getCreatedBy() != null)
                tasks.setCreatedBy(employeeRepository.findById(reqTask.getCreatedBy()).orElseThrow(() -> new EntityNotFoundException("xatolik")));
            if (reqTask.getUpdateBy() != null)
                tasks.setUpdatedBy(employeeRepository.findById(reqTask.getUpdateBy()).orElseThrow(() -> new EntityNotFoundException("Xaato")));
            tasksRepository.save(tasks);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String update(ReqTask reqTask) {
        try {
            if (reqTask.getId() != null) {
                if (tasksRepository.findById(reqTask.getId()).isPresent()) {
                    Task currentTask = tasksRepository.findById(reqTask.getId()).get();
                    currentTask.setTitle(reqTask.getTitle());
                    currentTask.setText(reqTask.getText());
                    currentTask.setDeadline(reqTask.getDeadline());
                    if (reqTask.getStatus() != null)
                        currentTask.setStatus(Status.valueOf(reqTask.getStatus()));
                    if (reqTask.getEmployee() != null)
                        currentTask.setEmployee(employeeRepository.findById(reqTask.getEmployee()).orElseThrow(() -> new EntityNotFoundException(" Ishchi topilmadi")));
                    if (reqTask.getCreatedBy() != null)
                        currentTask.setCreatedBy(employeeRepository.findById(reqTask.getCreatedBy()).orElseThrow(() -> new EntityNotFoundException("xato")));
                    if (reqTask.getUpdateBy() != null)
                        currentTask.setUpdatedBy(employeeRepository.findById(reqTask.getUpdateBy()).orElseThrow(() -> new EntityNotFoundException("Xaato")));
                    tasksRepository.save(currentTask);
                    return "Muvoffaqiyatli saqlandi!";
                } else {
                    return "Bunday topshiriq bazaga kiritilmagan";
                }
            }else {
                return "Topshiriq tanlanmadi";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Task> getAllTasks() {
        List<Task> all = tasksRepository.findAll();
        return all;
    }

    public Task getById(Long id) {
        Optional<Task> byId = tasksRepository.findById(id);
        if (byId.isPresent()) {
            Task tasks = byId.get();
            return tasks;
        } else {
            return new Task();
        }
    }

    public void delate(Long id) {
        Task tasks = tasksRepository.getReferenceById(id);
        tasksRepository.delete(tasks);
    }
}

package com.example.spring.service;

import com.example.spring.domain.Task;
import com.example.spring.domain.request.ReqTask;
import com.example.spring.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }


    public String createTask(ReqTask reqTask){
        try {
            Task tasks = new Task();
            tasks.setName(reqTask.getName());
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
            tasks.setId(reqTask.getId());
            tasks.setName(reqTask.getName());
            tasksRepository.save(tasks);
            return "Muvoffaqiyatli uzgartirildi!";
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

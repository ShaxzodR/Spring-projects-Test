package com.example.spring.service;

import com.example.spring.domain.Task;
import com.example.spring.domain.enumation.Status;
import com.example.spring.domain.request.ReqTask;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public String createTask(ReqTask reqTask);
    public String update(ReqTask reqTask);
    public List<Task> getAllTasks();
    public Task getById(Long id);
    public void delate(Long id);
}

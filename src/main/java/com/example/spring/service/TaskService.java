package com.example.spring.service;

import com.example.spring.domain.Task;
import com.example.spring.domain.request.ReqTask;

import java.util.List;

public interface TaskService {
     String createTask(ReqTask reqTask);
     String update(ReqTask reqTask);
     List<Task> getAllTasks();
     Task getById(Long id);
     void delate(Long id);
     void inActiveStatus(Long id);
     void activeStatus(Long id);
     Long tasksL(Long id);
     List<Task> findAllByEmployeeId(Long id);
     List<Task> filter(String type,String searchName);
}

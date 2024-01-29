package com.example.spring.web.rest;

import com.example.spring.domain.Task;
import com.example.spring.domain.request.ReqTask;
import com.example.spring.service.impl.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskResource {
    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqTask reqTask){
        String response = taskService.createTask(reqTask);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqTask reqTask){
        String response = taskService.update(reqTask);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Task tasks = taskService.getById(id);
        return ResponseEntity.ok(tasks);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delate(@PathVariable Long id){
        taskService.delate(id);
        return ResponseEntity.ok("O'chirildi");
    }


}

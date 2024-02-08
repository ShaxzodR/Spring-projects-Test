package com.example.spring.web.rest;

import com.example.spring.domain.Task;
import com.example.spring.domain.request.ReqEmployee;
import com.example.spring.domain.request.ReqTask;
import com.example.spring.service.TaskService;
import com.example.spring.service.impl.TaskServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskResource {
    private final TaskService taskService;

    public TaskResource(TaskServiceImpl taskService) {
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
    @GetMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable Long id){
        taskService.activeStatus(id);
        return ResponseEntity.ok("Aktiv holatga utkazildi");
    }
    @GetMapping("/inactive/{id}")
    public ResponseEntity<?> inActive(@PathVariable Long id){
        taskService.inActiveStatus(id);
        return ResponseEntity.ok("Aktiv holatga utkazilmadi");
    }
    @GetMapping("/taskCount/{id}")
    public ResponseEntity<?> taskCount(@PathVariable Long id){
        Long task = taskService.tasksL(id);
        return ResponseEntity.ok("task lar soni="+task);
    }
    @GetMapping("/findE/{id}")
    public ResponseEntity<?> findOllByEmployeeId(@PathVariable Long id){
        List<Task> task = taskService.findAllByEmployeeId(id);
        return ResponseEntity.ok(task);
    }


}

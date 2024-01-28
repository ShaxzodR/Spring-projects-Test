package com.example.spring.web.rest;

import com.example.spring.domain.TaskEmployee;
import com.example.spring.domain.request.ReqTaskEmployee;
import com.example.spring.service.TaskEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-employee")
public class TaskEmployeeResource {
    private final TaskEmployeeService taskEmployeeService;

    public TaskEmployeeResource(TaskEmployeeService taskEmployeeService) {
        this.taskEmployeeService = taskEmployeeService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqTaskEmployee reqTaskEmployee){
        String response = taskEmployeeService.create(reqTaskEmployee);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqTaskEmployee reqTaskEmployee){
        String response = taskEmployeeService.update(reqTaskEmployee);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<?> all(){
        List<TaskEmployee> all = taskEmployeeService.all();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id){
        TaskEmployee taskEmployee = taskEmployeeService.byId(id);
        return ResponseEntity.ok(taskEmployee);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@PathVariable Long id){
        taskEmployeeService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }
}

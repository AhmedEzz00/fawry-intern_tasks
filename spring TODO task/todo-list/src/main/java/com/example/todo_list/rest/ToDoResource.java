package com.example.todo_list.rest;

import com.example.todo_list.model.Task;
import com.example.todo_list.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 import java.util.List;

 @RestController
 @RequestMapping("todo")
 public class ToDoResource {

     private final ToDoService toDoService;

     @Autowired
     public ToDoResource(@Qualifier("database") ToDoService toDoService){
         this.toDoService= toDoService;
     }

     @GetMapping("/all/{userName}")
     ResponseEntity<List<Task>> findAllTasks(@PathVariable("userName") String userName){
         return ResponseEntity.ok(toDoService.findTasksForSpecificUser(userName));
     }

     @PostMapping(value = "/{userName}")
     void insertTask(@PathVariable("userName") String userName,@RequestBody @Valid Task task) {
         toDoService.addTaskToUser(userName,task);
     }

     @DeleteMapping(value = "/delete",params = {"taskNumber","userName"})
     void deleteTask(@RequestParam("taskNumber") int taskNumber,@RequestParam("userName") String userName){
         toDoService.deleteTask(taskNumber, userName);
     }

 }

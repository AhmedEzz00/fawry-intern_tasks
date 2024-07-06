package com.example.todo_list.service;

import com.example.todo_list.model.Task;

import java.util.List;

public interface ToDoService {
    void addTaskToUser(String userName, Task task);

    List<Task> findTasksForSpecificUser(String userName);

   void deleteTask(int taskNumber, String userName);
}

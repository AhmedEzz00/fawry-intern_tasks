package com.example.todo_list.service.impl;

import com.example.todo_list.error.exceptions.NotFoundException;
import com.example.todo_list.model.Task;
import com.example.todo_list.repository.TasksRepository;
import com.example.todo_list.repository.entity.TaskEntity;
import com.example.todo_list.repository.entity.UserEntity;
import com.example.todo_list.service.ToDoService;
import com.example.todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("database")
public class ToDoServiceWithDatabaseImpl implements ToDoService {

    private final TasksRepository tasksRepository;
    private final UserService userService;

    @Autowired
    public ToDoServiceWithDatabaseImpl(TasksRepository tasksRepository, UserService userService){
        this.userService=userService;
        this.tasksRepository= tasksRepository;
    }

    @Override
    public void addTaskToUser(String userName, Task task) {
        UserEntity userEntity= userService.createUserIfNotExists(userName);
        TaskEntity taskEntity= new TaskEntity();
        mapTaskToEntity(userEntity, task, taskEntity);
        tasksRepository.save(taskEntity);

    }


    @Override
    public List<Task> findTasksForSpecificUser(String userName) {
        userService.verifyUserExistence(userName);
        return tasksRepository.findByUserName(userName)
                .stream()
                .map(taskEntity -> {
                    Task task= new Task();
                    mapEntityToTask(taskEntity, task);
                    return task;
                }).toList();
    }



    @Override
    public void deleteTask(int taskId, String userName) {
        verifyTaskExistence(taskId);
        tasksRepository.deleteById(taskId);
    }


    private void verifyTaskExistence(long taskId){
        Optional<TaskEntity> optionalTask= tasksRepository.findById(taskId);
        if (!optionalTask.isPresent()){
            throw new NotFoundException("task with id: "+taskId+" not found");
        }
    }

    private void mapTaskToEntity(UserEntity userEntity, Task task, TaskEntity taskEntity) {
        taskEntity.setBody(task.getBody());
        taskEntity.setUser(userEntity);
    }

    private void mapEntityToTask(TaskEntity taskEntity, Task task) {
        task.setBody(taskEntity.getBody());
        task.setId(taskEntity.getId());
        //task.setFileName(taskEntity.getUser().getName());
    }

}

package com.example.todo_list.repository;

import com.example.todo_list.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findByUserName(String userName);

    void deleteById(long id);
}

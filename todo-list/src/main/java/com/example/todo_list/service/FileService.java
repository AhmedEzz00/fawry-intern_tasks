package com.example.todo_list.service;

import com.example.todo_list.model.Task;

import java.util.List;

public interface FileService {

    List<String> readLinesFromFile(String filePath);
    void writeToFile(Task task, String filePath);
    void clearFile(String filePath);
}

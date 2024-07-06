package com.example.todo_list.service.impl;

import com.example.todo_list.model.Task;
import com.example.todo_list.service.FileService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void writeToFile(Task task, String filePath) {
        File file= new File(filePath);
        createFileIfDoesntExist(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.append("Task").append(String.valueOf(task.getTaskNumber())).append(": ").append(task.getBody());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readLinesFromFile(String filePath) {
        File file= new File(filePath);
        List<String> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }


    @Override
    public void clearFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFileIfDoesntExist(File file) {
       try {
           if(!file.exists()){
               file.createNewFile();
           }
       }catch (IOException ex){
           ex.printStackTrace();
       }
    }
}



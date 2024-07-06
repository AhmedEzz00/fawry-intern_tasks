package com.example.todo_list.service.impl;

import com.example.todo_list.service.FileService;
import com.example.todo_list.service.ToDoService;
import com.example.todo_list.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service("files")
public class ToDoServiceWithFilesImpl implements ToDoService {

    private final FileService fileService;

    @Autowired
    public ToDoServiceWithFilesImpl(FileService fileService){
        this.fileService = fileService;
    }

    @Override
    public void addTaskToUser(String fileName, Task task) {
        String filePath= "created files/"+fileName+".txt";
        task.setTaskNumber(getCurrentTaskNumber(filePath));
        fileService.writeToFile(task, filePath);
    }

    @Override
    public List<Task> findTasksForSpecificUser(String fileName) {
        return getFormattedTasks(fileName);
    }

    @Override
    public void deleteTask(int taskNumber, String fileName) {
        String filePath= "created files/"+fileName+".txt";
        List<Task> allTasks= getFormattedTasks(fileName);
        removeTaskFromList(taskNumber, allTasks);
        fileService.clearFile(filePath);
        setUndeletedValues(filePath,allTasks);
    }

    private List<String> readUnFormattedTasks(String filePath) {
        List<String> tasks = new ArrayList<>();
        tasks = fileService.readLinesFromFile(filePath);
        return tasks;
    }

    private int getCurrentTaskNumber(String filePath) {
        return readUnFormattedTasks(filePath).size()+ 1;
    }
    private List<Task> getFormattedTasks(String fileName){
        String filePath= "created files/"+fileName+".txt";
        return readUnFormattedTasks(filePath)
                .stream()
                .map((unFormattedTask) -> mapStringToTaskObject(unFormattedTask,fileName))
                .collect(Collectors.toList());
    }
    private Task mapStringToTaskObject(String unFormattedTask,String fileName){
        Pattern pattern = Pattern.compile("^Task(\\d+):\\s*(.*)");
        Matcher matcher = pattern.matcher(unFormattedTask);
        if (matcher.find()) {
            int taskNumber = Integer.parseInt(matcher.group(1));
            String body = matcher.group(2);
            return new Task(taskNumber, fileName, body);
        } else {
            return null;
        }
    }

    private void setUndeletedValues(String filePath, List<Task> allTasks) {
        allTasks.forEach(task -> fileService.writeToFile(task, filePath));
    }
    private void removeTaskFromList(int taskNumber, List<Task> allTasks) {
        Optional<Task> toBeDeleted=   allTasks.stream()
                .filter(task -> task.getTaskNumber() == taskNumber).findFirst();
        if (toBeDeleted.isPresent()) {
            allTasks.remove(toBeDeleted.get());
            setNumbersForTasks(allTasks);
        }
    }

    private void setNumbersForTasks(List<Task> allTasks) {
        for (int i= 0;i<allTasks.size();i++){
            allTasks.get(i).setTaskNumber(i+1);
        }
    }


}

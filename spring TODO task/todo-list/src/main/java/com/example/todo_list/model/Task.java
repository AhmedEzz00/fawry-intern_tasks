package com.example.todo_list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Task {

    private long id;

    @JsonIgnore
    private int taskNumber;

    @JsonIgnore
    private String fileName;

    @NotBlank(message = "field cant be blank")
    private String body;

    //private UserModel userModel;

    public Task(int taskNumber, String fileName, String body) {
    }

//    public Task(String body){
//        this.body= body;
//    }
//
//    public Task(String fileName, String body) {
//        this.fileName = fileName;
//        this.body = body;
//    }

}

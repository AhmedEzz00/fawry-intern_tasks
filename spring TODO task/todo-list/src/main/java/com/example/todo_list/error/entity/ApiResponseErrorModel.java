package com.example.todo_list.error.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponseErrorModel {
    private String message;

    private boolean success;

    private HttpStatusCode status;

    private int statusCode;

    public ApiResponseErrorModel(String message,HttpStatusCode status,int statusCode){
        this.message= message;
        this.status= status;
        this.success= Boolean.FALSE;
        this.statusCode= statusCode;
    }
}

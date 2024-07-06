package com.example.todo_list.error.exceptionHandler;

import com.example.todo_list.error.entity.ApiResponseErrorModel;
import com.example.todo_list.error.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpecificExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex){
        ApiResponseErrorModel errorModel= new ApiResponseErrorModel(ex.getMessage(),
                HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value() );
        return ResponseEntity.ok(errorModel);

    }


}

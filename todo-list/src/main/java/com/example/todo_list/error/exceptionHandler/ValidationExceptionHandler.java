package com.example.todo_list.error.exceptionHandler;

import com.example.todo_list.error.entity.ApiResponseErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
            , HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApiResponseErrorModel error = new ApiResponseErrorModel(
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                status,
                status.value());
        return ResponseEntity.status(status).body(error);
    }
}


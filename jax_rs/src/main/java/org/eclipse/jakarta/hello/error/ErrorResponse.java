package org.eclipse.jakarta.hello.error;

import jakarta.ws.rs.core.Response;
import jdk.jshell.Snippet;

public class ErrorResponse {
    private String error;
    private String message;

    private int statusCode;

    public ErrorResponse(String error, String message, int statusCode) {
        this.error = error;
        this.message = message;
        this.statusCode= statusCode;
    }

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode= statusCode;
    }


    // Getters and Setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
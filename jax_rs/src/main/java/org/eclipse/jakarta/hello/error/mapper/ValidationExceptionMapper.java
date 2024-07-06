package org.eclipse.jakarta.hello.error.mapper;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.jakarta.hello.error.ErrorResponse;

import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        List<ErrorResponse> errors = exception.getConstraintViolations().stream()
                .map(this::mapViolation)
                .collect(Collectors.toList());
        return jakarta.ws.rs.core.Response.status(Status.BAD_REQUEST)
                .entity(errors)
                .build();
    }

    private ErrorResponse mapViolation(ConstraintViolation<?> violation) {
        return new ErrorResponse(violation.getPropertyPath().toString(), violation.getMessage(), Status.BAD_REQUEST.getStatusCode());
    }
}

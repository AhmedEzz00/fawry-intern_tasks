package org.eclipse.jakarta.hello.error.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.jakarta.hello.error.ErrorResponse;
import org.eclipse.jakarta.hello.error.exceptions.ProductNotFoundException;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException>{


    @Override
    public Response toResponse(ProductNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(exception.getMessage(),Response.Status.NOT_FOUND.getStatusCode() ))
                .build();
    }

//    @Override
//    public Response toResponse(Throwable throwable) {
//        return null;
//    }
}

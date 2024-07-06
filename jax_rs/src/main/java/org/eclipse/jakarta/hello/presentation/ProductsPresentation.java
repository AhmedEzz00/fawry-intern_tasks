package org.eclipse.jakarta.hello.presentation;

import jakarta.ejb.Singleton;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jakarta.hello.entity.Product;
import org.eclipse.jakarta.hello.service.IProductService;
import org.eclipse.jakarta.hello.service.ProductServiceImpl;


import java.awt.*;
import java.util.List;

@Path("/products")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductsPresentation {

    IProductService productService= new ProductServiceImpl();

    @GET
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GET
    @Path("/{name}")
    public Product findByName(@PathParam("name") String name){
        return productService.findByName(name);
    }

    @POST
    public void addProduct(@Valid Product product){
        productService.addProduct(product);
    }

    @PUT
    public void updateProduct(@Valid Product product){
        productService.updateProduct(product);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id){
        productService.deleteProduct(id);
    }
}

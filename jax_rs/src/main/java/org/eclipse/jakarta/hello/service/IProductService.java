package org.eclipse.jakarta.hello.service;

import org.eclipse.jakarta.hello.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findByName(String name);

    //Product findById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);
}

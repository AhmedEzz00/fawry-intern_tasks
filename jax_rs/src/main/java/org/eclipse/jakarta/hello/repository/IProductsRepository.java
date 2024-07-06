package org.eclipse.jakarta.hello.repository;

import org.eclipse.jakarta.hello.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductsRepository {
    List<Product> findAll();

    Optional<Product> findById(int id);

    Optional<Product> findByName(String name);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);
}

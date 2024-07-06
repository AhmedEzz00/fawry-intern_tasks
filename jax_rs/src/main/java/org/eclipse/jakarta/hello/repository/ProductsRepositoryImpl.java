package org.eclipse.jakarta.hello.repository;

import jakarta.ejb.Singleton;
import org.eclipse.jakarta.hello.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class ProductsRepositoryImpl implements IProductsRepository {
    private final List<Product> products= new ArrayList<>();
    private int currentId = 1;

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(product -> product.getId()== id)
                .findFirst();
    }


    @Override
    public Optional<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public void addProduct(Product product) {
        product.setId(currentId++);
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct= products.stream().filter(p -> p.getId()== product.getId()).findFirst().get();
        products.set(products.indexOf(existingProduct), product);
    }

    @Override
    public void deleteProduct(int productId) {
        products.removeIf(product -> product.getId()== productId);
    }
}

package org.eclipse.jakarta.hello.service;

import org.eclipse.jakarta.hello.entity.Product;
import org.eclipse.jakarta.hello.error.exceptions.ProductNotFoundException;
import org.eclipse.jakarta.hello.repository.IProductsRepository;
import org.eclipse.jakarta.hello.repository.ProductsRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements IProductService{

    IProductsRepository productsRepo= new ProductsRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productsRepo.findAll();
    }


    @Override
    public Product findByName(String name) {
        Optional<Product> optionalProduct= productsRepo.findByName(name);
        if (!optionalProduct.isPresent())
            throw new ProductNotFoundException("product: "+name+ " not found");;
        return optionalProduct.get();
    }

//    @Override
//    public Product findById(int id) {
//        productNotExist(id);
//        return productsRepo.findById();
//    }

    @Override
    public void addProduct(Product product)  {
        if (product.getName()== null || product.getPrice()== 0.0)
                throw new RuntimeException();

        productsRepo.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        checkProductExistance(product.getId());
        productsRepo.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        checkProductExistance(productId);
        productsRepo.deleteProduct(productId);

    }

    private void checkProductExistance(int productId) {
        if (!productsRepo.findById(productId).isPresent())
            throw new ProductNotFoundException("product with id: "+productId+" is not found");;
    }
}

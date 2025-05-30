package com.base.basecrud.service;

import com.base.basecrud.model.Order;
import com.base.basecrud.model.Product;
import com.base.basecrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createOrder(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Producto no encontrado con ID" + id));
        return product;
    }

    @Override
    public Product upDateOrder(Long id,String name, Double price ) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Producto no encontrado con ID" + id));
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Producto no encontrado con ID" + id));
        productRepository.delete(product);
    }
}

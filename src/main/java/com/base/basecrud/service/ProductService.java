package com.base.basecrud.service;


import com.base.basecrud.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    Product findById(Long id);
    Product upDateProduct(Long id,String name,Double price);
    List<Product> findAll();
    void deleteProductById(Long id);
}

package com.base.basecrud.service;

import com.base.basecrud.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createOrder();
    Optional<Product> findById();
    Optional<Product> upDateUser();
    List<Product> findAll();
    Optional<Product> deleteProductById();
}

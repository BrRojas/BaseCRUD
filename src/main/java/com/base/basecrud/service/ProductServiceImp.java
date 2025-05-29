package com.base.basecrud.service;

import com.base.basecrud.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImp implements ProductService{
    @Override
    public Product createOrder() {
        return null;
    }

    @Override
    public Optional<Product> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<Product> upDateUser() {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> deleteProductById() {
        return Optional.empty();
    }
}

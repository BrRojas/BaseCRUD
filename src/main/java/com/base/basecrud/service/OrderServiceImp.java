package com.base.basecrud.service;

import com.base.basecrud.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderServiceImp implements OrderService{
    @Override
    public Order createOrder() {
        return null;
    }

    @Override
    public Optional<Order> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<Order> upDateUser() {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Optional<Order> deleteOrderById() {
        return Optional.empty();
    }
}

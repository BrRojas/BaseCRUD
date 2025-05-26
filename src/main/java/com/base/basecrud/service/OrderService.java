package com.base.basecrud.service;

import com.base.basecrud.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder();
    Optional<Order> findById();
    Optional<Order> upDateUser();
    List<Order> findAll();
    Optional<Order> deleteOrderById();

}

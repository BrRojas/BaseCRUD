package com.base.basecrud.service;

import com.base.basecrud.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);
    Order findById(Long id);
    //Order upDateUser(Long id);
    List<Order> findAll();
    void deleteOrderById(Long id);

}

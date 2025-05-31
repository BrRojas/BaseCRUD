package com.base.basecrud.service;

import com.base.basecrud.model.Order;
import com.base.basecrud.model.Product;
import com.base.basecrud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderServiceImp implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        return order;
    }

    @Override
    public Order upDateUser(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        orderRepository.delete(order);
    }
}

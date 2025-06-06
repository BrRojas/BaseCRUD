package com.base.basecrud.service;

import com.base.basecrud.model.Order;
import com.base.basecrud.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrderServiceImpTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImp orderServiceImp;



    @Test
    void createOrder() {

        Order order = new Order(null,null,null);
        Order savedOrder = new Order(1L,null,null);

        when(orderRepository.save(order)).thenReturn(savedOrder);

        Order result = orderServiceImp.createOrder(order);

        assertEquals(1L,result.getId());
        assertEquals(null,result.getUser());
        assertEquals(null,result.getProducts());
        verify(orderRepository).save(order);

    }

    @Test
    void findById() {

        Long id = 1L;
        Order order = new Order(id,null,null);

        when(orderRepository.findById(id)).thenReturn(Optional.of(order));

        Order result = orderServiceImp.findById(id);


        assertEquals(null,result.getUser());
        assertEquals(null,result.getProducts());
        verify(orderRepository).findById(id);
    }

    @Test
    void findAll() {

        List<Order> orders = List.of(
                new Order(1L,null,null),
                new Order(2L, null,null)
        );


        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderServiceImp.findAll();

        assertEquals(2, result.size());
        assertEquals(null, result.get(0).getUser());

        verify(orderRepository).findAll();

    }

    @Test
    void deleteOrderById() {

        Long id = 1L;
        Order order = new Order(id,null,null);

        when(orderRepository.findById(id)).thenReturn(Optional.of(order));

        orderServiceImp.deleteOrderById(id);

        verify(orderRepository).delete(order);

    }
}
package com.base.basecrud.controller;

import com.base.basecrud.model.Order;
import com.base.basecrud.service.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;


    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderServiceImp.createOrder(order);
    }


    @GetMapping("/{id}")
    public Order findProductById(@PathVariable Long id){
        return orderServiceImp.findById(id);
    }


    @GetMapping
    public List<Order> getAllProduct(){
        return orderServiceImp.findAll();
    }


    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        orderServiceImp.deleteOrderById(id);
    }

    
}

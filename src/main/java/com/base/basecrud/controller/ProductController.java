package com.base.basecrud.controller;

import com.base.basecrud.model.Product;
import com.base.basecrud.model.User;
import com.base.basecrud.repository.ProductRepository;
import com.base.basecrud.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productServiceImp.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product upDateProduct(@PathVariable Long id, @RequestBody String name, Double price){
        return productServiceImp.upDateProduct(id, name, price);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productServiceImp.findById(id);
    }


    @GetMapping
    public List<Product> getAllProduct(){
        return productServiceImp.findAll();
    }


    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productServiceImp.deleteProductById(id);
    }

}

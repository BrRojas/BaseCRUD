package com.base.basecrud.service;

import com.base.basecrud.model.Product;
import com.base.basecrud.repository.ProductRepository;
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
class ProductServiceImpTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productServiceImp;



    @Test
    void createProduct() {
        Product product = new Product(null,"Notebook",100.00,null);
        Product savedProduct = new Product(1L,"Notebook",100.00,null);

        when(productRepository.save(product)).thenReturn(savedProduct);

        Product result = productServiceImp.createProduct(product);

        assertEquals(1L,result.getId());
        assertEquals("Notebook",result.getName());
        assertEquals(100.00,result.getPrice());
        verify(productRepository).save(product);


    }

    @Test
    void findById() {
        Long id = 1L;
        Product product = new Product(id,"Notebook",100.00,null);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Product result = productServiceImp.findById(id);


        assertEquals("Notebook",result.getName());
        assertEquals(100.00,result.getPrice());
        verify(productRepository).findById(id);




    }

    @Test
    void upDateProduct() {
        Long id = 1L;
        Product existingProduct = new Product(id, "Notebook", 100.00, null);
        Product updatedProduct = new Product(id, "Computadora", 99.99, null);

        when(productRepository.findById(id)).thenReturn(Optional.of(existingProduct));

        Product result = productServiceImp.upDateProduct(id, "Computadora", 99.99);

        assertEquals("Computadora", result.getName());
        assertEquals(99.99, result.getPrice());
        verify(productRepository).findById(id);
    }


    @Test
    void findAll() {

        List<Product> products = List.of(
                new Product(1L,"Notebook",100.00,null),
                new Product(2L,"Tele", 101.00,null)
        );


        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productServiceImp.findAll();

        assertEquals(2, result.size());
        assertEquals("Notebook", result.get(0).getName());
        assertEquals("Tele", result.get(1).getName());
        assertEquals(100.00, result.get(0).getPrice());
        assertEquals(101.00, result.get(1).getPrice());
        verify(productRepository).findAll();

    }

    @Test
    void deleteProductById() {
        Long id = 1L;
        Product product = new Product(id,"Notebook",100.00,null);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        productServiceImp.deleteProductById(id);

        verify(productRepository).delete(product);

    }
}
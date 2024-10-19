package com.example.crud.controller;
package com.example.crud.service;

import com.example.crud.model.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private List<ProductEntity> products = new ArrayList<>();

    public ProductService() {
        products.add(new ProductEntity("Laptop", "Electrónica", 1000.00, 50));
        products.add(new ProductEntity("Silla", "Muebles", 150.00, 30));
        products.add(new ProductEntity("Cámara", "Fotografía", 500.00, 15));
    }

    public List<ProductEntity> getAllProducts() {
        return products;
    }

    public Optional<ProductEntity> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public ProductEntity addProduct(ProductEntity product) {
        product.setId(UUID.randomUUID());

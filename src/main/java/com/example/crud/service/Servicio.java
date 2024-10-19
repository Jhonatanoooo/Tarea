package com.example.crud.service;

import com.example.crud.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Servicio {
    private List<Producto> products = new ArrayList<>();

    public Servicio() {

        products.add(new Producto("Laptop", "Electrónica", 1000.00, 50));
        products.add(new Producto("Silla", "Muebles", 150.00, 30));
        products.add(new Producto("Cámara", "Fotografía", 500.00, 15));
    }


    public List<Producto> getAllProducts() {
        return products;
    }

    public Optional<Producto> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public Producto addProduct(Producto product) {
        product.setId(UUID.randomUUID());
        products.add(product);
        return product;
    }

    public Optional<Producto> updateProduct(UUID id, Producto updatedProduct) {
        Optional<Producto> existingProduct = getProductById(id);
        existingProduct.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
        });
        return existingProduct;
    }

    public boolean deleteProduct(UUID id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}

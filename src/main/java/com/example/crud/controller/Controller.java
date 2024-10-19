package com.example.crud.controller;

import com.example.crud.model.Producto;
import com.example.crud.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class Controller
{
    @Autowired
    private Servicio servicio;

    @GetMapping
    public List<Producto> getAllProducts()
    {
        return servicio.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductById(@PathVariable UUID id)
    {
        return servicio.getProductById(id);
    }

    @PostMapping
    public Producto addProduct(@RequestBody Producto product
    {
        return servicio.addProduct(product);
    }

    @PutMapping("/{id}")
    public Optional<Producto> updateProduct(@PathVariable UUID id, @RequestBody Producto product) {
        return servicio.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable UUID id)
    {
        return servicio.deleteProduct(id);
    }
}

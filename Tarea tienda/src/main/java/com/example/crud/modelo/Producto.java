package com.example.crud.controller;
package com.example.crud.model;

import java.util.UUID;

public class ProductEntity {
    private UUID id;
    private String name;
    private String category;
    private double price;
    private int stock;

    public ProductEntity(String name, String category, double price, int stock) {
        this.id = UUID.random

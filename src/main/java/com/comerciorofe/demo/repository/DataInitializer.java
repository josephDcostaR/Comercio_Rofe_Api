package com.comerciorofe.demo.repository;

import com.comerciorofe.demo.entities.Department;
import com.comerciorofe.demo.entities.Product;


import java.util.LinkedList;
import java.util.List;

public class DataInitializer {
    
    public static List<Product> initializeData() {
        Department d1 = new Department(1L, "Tech");
        Department d2 = new Department(2L, "Pet");
        Department d3 = new Department(3L, "Comida");

        Product p1 = new Product(1L, "Mac book", 4000.0, d1);
        Product p2 = new Product(2L, "PC Gamer", 5000.0, d1);
        Product p3 = new Product(3L, "Pet House", 300.0, d2);
        Product p4 = new Product(4L, "Pizza", 20.0, d3);

        LinkedList<Product> products = new LinkedList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        return products;
    }
}

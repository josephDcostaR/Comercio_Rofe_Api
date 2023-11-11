package com.comerciorofe.demo.services;

import com.comerciorofe.demo.entities.Product;
import com.comerciorofe.demo.repository.DataInitializer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private LinkedList<Product> productList = new LinkedList<>();


    public ProductService() {
        productList = (LinkedList<Product>) DataInitializer.initializeData();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product findProductById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public LinkedList<Product> createProducts(LinkedList<Product> products) {
     LinkedList<Product> createdProducts = new LinkedList<>();
    
    for (Product product : products) {
        long newProductId = productList.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0) + 1;

        if (productList.stream().anyMatch(p -> p.getId() == newProductId)) {
            // O novo ID gerado já existe, você pode lidar com isso de alguma forma.
            // Neste exemplo, estou apenas retornando null, mas você pode tomar uma ação diferente.
            createdProducts.add(null);
        } else {
            product.setId(newProductId);
            if (productList.add(product)) {
                createdProducts.add(product);
            } else {
                createdProducts.add(null);
            }
        }
    }

    return createdProducts;
}

    public Product removeProduct(Product product) {
        if (productList.remove(product)) {
            return product;
        } else {
            return null; 
        }
    }

    public Product editProduct(Long id, Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getId().equals(id)) {
                productList.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }
}

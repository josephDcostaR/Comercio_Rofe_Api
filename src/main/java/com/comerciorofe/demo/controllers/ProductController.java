package com.comerciorofe.demo.controllers;
import java.util.LinkedList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.comerciorofe.demo.entities.Product;
import com.comerciorofe.demo.services.ProductService;
import com.comerciorofe.demo.services.exception.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;
    
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping
    public List<Product> getAll(){
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado");
        }
       return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product  =  productService.findProductById(id);
        if (product != null){
            return ResponseEntity.ok(product);
        } else {
             throw new ResourceNotFoundException("Este produto não foi encontrado encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<LinkedList<Product>> createProduct(@RequestBody LinkedList<Product> products){
        try {
            LinkedList<Product> createdProducts = productService.createProducts(products);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProducts);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Não foi possível criar esse produto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        Product product = productService.findProductById(id);
        if (product != null) {
            Product deleted = productService.removeProduct(product);
            if (deleted != null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            throw new ResourceNotFoundException("Este produto não foi encontrado encontrado");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.findProductById(id);
        if (product != null) {
            updatedProduct = productService.editProduct(id, updatedProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            throw new ResourceNotFoundException("Este produto não foi encontrado encontrado");
        }
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
 
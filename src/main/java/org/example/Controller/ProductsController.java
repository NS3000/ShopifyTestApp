package org.example.Controller;

import org.example.DTO.ProductRequestDTO;
import org.example.Entity.AccessToken;
import org.example.Entity.Product;
import org.example.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }
    @GetMapping("/list")
    public ResponseEntity<String> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProducts(@RequestBody ProductRequestDTO product) throws IOException {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editProduct(@PathVariable("id") long id,@RequestBody ProductRequestDTO updatedProduct){
        return productService.editProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted Successfully!");
    }
}

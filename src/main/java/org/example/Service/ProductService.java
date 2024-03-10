package org.example.Service;

import org.example.DTO.ProductRequestDTO;
import org.example.Entity.Product;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.awt.geom.RectangularShape;
import java.io.IOException;

public interface ProductService {
    public ResponseEntity<String> getAllProducts();
    public ResponseEntity<String> addProduct(ProductRequestDTO product) throws IOException;
    public ResponseEntity<String> getProduct(long id);
    public ResponseEntity<String> editProduct(long id,ProductRequestDTO updatedProduct);
    public ResponseEntity<String> deleteProduct(long id);
 }

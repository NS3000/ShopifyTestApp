package org.example.Controller;

import org.example.Entity.Customer;
import org.example.Entity.Order;
import org.example.Entity.Product;
import org.example.Exceptions.CustomerNotFoundException;
import org.example.Exceptions.ProductNotFoundException;
import org.example.Repository.CustomerRepository;
import org.example.Repository.OrderRepository;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loocal")
public class LocalController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;


    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException());
        return new  ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
        return new  ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id){
        Order order = orderRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException());
        return new  ResponseEntity<>(order, HttpStatus.OK);
    }


}

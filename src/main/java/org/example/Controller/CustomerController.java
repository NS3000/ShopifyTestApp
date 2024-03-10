package org.example.Controller;

import org.example.DTO.CustomerRequestDTO;
import org.example.Entity.Customer;
import org.example.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customers")
public class CustomerController {

    @Value("${access_token}")
    String accessToken;
    @Value("${shop}")
    private String store;
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomer(@PathVariable("id") long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/list")
    public ResponseEntity<String> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomers(@RequestBody CustomerRequestDTO customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") long id,@RequestBody CustomerRequestDTO customer){
        return customerService.editCustomers(id,customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
         customerService.deleteCustomer(id);
         return ResponseEntity.ok("customer Deleted Successfully.");
    }




}

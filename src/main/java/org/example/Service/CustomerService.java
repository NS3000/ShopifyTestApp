package org.example.Service;

import org.example.DTO.CustomerRequestDTO;
import org.example.Entity.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<String> addCustomer(CustomerRequestDTO customer);
    ResponseEntity<String> getAllCustomers();
    ResponseEntity<String> editCustomers(long id,CustomerRequestDTO editedCustomer);
    ResponseEntity<String> getCustomer(long id);

    ResponseEntity<String> deleteCustomer(long id);
}

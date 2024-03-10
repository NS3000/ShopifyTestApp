package org.example.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.example.Entity.Customer;
import org.example.Entity.Order;
import org.example.Entity.Product;
import org.example.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ProductVariantRepository productVariantRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Transactional
    public void handleProducts(String topic, String data) throws JsonProcessingException {

        Product product = objectMapper.readValue(data, Product.class);

        switch (topic) {
            case "products/create" -> productRepository.save(product);
            case "products/delete" -> productRepository.deleteById(product.getId());
            case "products/update" -> {
                productVariantRepository.setIsDeletedTrue(product.getId());
                productVariantRepository.deleteUnused();

                imageRepository.setIsDeletedTrue(product.getId());
                imageRepository.deleteUnused();

                productRepository.save(product);
            }
        }
    }

    @Transactional
    public void handleCustomers(String topic, String data) throws JsonProcessingException {

        Customer customer = objectMapper.readValue(data,Customer.class);

        switch (topic) {
            case "customers/create" -> customerRepository.save(customer);
            case "customers/delete" -> customerRepository.deleteById(customer.getId());
            case "customers/update" -> {
                addressRepository.setIsDeletedTrue(customer.getId());
                addressRepository.deleteUnused();

                customerRepository.save(customer);
            }
        }
    }

    @Transactional
    public void handleOrders(String topic, String data) throws JsonProcessingException {
        Order order = objectMapper.readValue(data, Order.class);

        switch (topic) {
            case "orders/create" -> orderRepository.save(order);
            case "orders/delete" -> orderRepository.deleteById(order.getId());
            case "orders/cancelled" -> orderRepository.save(order);
            case "orders/updated" -> orderRepository.save(order);
            case "orders/fulfilled" -> orderRepository.save(order);
            case "orders/partially_fulfilled" ->orderRepository.save(order);
        }
    }
}

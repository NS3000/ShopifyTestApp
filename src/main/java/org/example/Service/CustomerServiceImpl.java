package org.example.Service;

import org.example.DTO.CustomerRequestDTO;
import org.example.Entity.Customer;
import org.example.DTO.ShopifyRequests.CustomerShopifyRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Value("${access_token}")
    String accessToken;
    @Value("${shop}")
    private String store;

    @Override
    public ResponseEntity<String> addCustomer(CustomerRequestDTO customer) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/customers.json";
        CustomerShopifyRequest request=new CustomerShopifyRequest(customer);
        HttpEntity<CustomerShopifyRequest> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);
    }

    @Override
    public ResponseEntity<String> getAllCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/customers.json";
        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    @Override
    public ResponseEntity<String> editCustomers(long id,CustomerRequestDTO editedCustomer) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        CustomerShopifyRequest request=new CustomerShopifyRequest(editedCustomer);
        HttpEntity<CustomerShopifyRequest> entity = new HttpEntity<>(request,headers);

        String url="https://"+store+".myshopify.com/admin/api/2024-01/customers/"+id+".json";
        return restTemplate.exchange(url, HttpMethod.PUT,entity, String.class);
    }

    @Override
    public ResponseEntity<String> getCustomer(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url="https://"+store+".myshopify.com/admin/api/2024-01/customers/"+id+".json";
        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/customers/"+id+".json";
        return restTemplate.exchange(url,HttpMethod.DELETE,entity, String.class);

    }
}


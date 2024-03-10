package org.example.Service;

import org.example.DTO.ProductRequestDTO;
import org.example.DTO.ShopifyRequests.ProductShopifyRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Value("${access_token}")
    String accessToken;
    @Value("${shop}")
    private String store;


    @Override
    public ResponseEntity<String> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/products.json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);

    }

    @Override
    public ResponseEntity<String> getProduct(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/products/"+id+".json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    @Override
    public ResponseEntity<String> addProduct(ProductRequestDTO product) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/products.json";
        ProductShopifyRequest request = new ProductShopifyRequest(product);
        HttpEntity<ProductShopifyRequest> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);
    }

    @Override
    public ResponseEntity<String> editProduct(long id, ProductRequestDTO updatedProduct) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/products/"+id+".json";
        ProductShopifyRequest request = new ProductShopifyRequest(updatedProduct);
        HttpEntity<ProductShopifyRequest> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.PUT,entity, String.class);    }

    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/products/"+id+".json";

        return restTemplate.exchange(url,HttpMethod.DELETE,entity, String.class);

    }
}

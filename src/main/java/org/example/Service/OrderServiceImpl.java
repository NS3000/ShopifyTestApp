package org.example.Service;

import org.example.DTO.OrderRequestDTO;
import org.example.DTO.ShopifyRequests.OrderShopifyRequest;
import org.example.DTO.OrderUpdateRequestDTO;
import org.example.DTO.ShopifyRequests.OrderUpdateRequestShopify;
import org.example.DTO.FulfillmentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Value("${access_token}")
    String accessToken;
    @Value("${shop}")
    private String store;

    @Override
    public ResponseEntity<String> getAllOrders() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders.json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    @Override
    public ResponseEntity<String> addOrder(OrderRequestDTO orderRequestDTO) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders.json";
        OrderShopifyRequest request = new OrderShopifyRequest(orderRequestDTO);
        HttpEntity<OrderShopifyRequest> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);    }

    @Override
    public ResponseEntity<String> cancelOrder(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+id+"/cancel.json";

        return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);    }

    @Override
    public ResponseEntity<String> getOrder(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+id+".json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    @Override
    public ResponseEntity<String> editOrder(long id, OrderUpdateRequestDTO orderUpdateRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+id+".json";
        OrderUpdateRequestShopify request = new OrderUpdateRequestShopify(orderUpdateRequestDTO);
        HttpEntity<OrderUpdateRequestShopify> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.PUT,entity, String.class);
    }

    @Override
    public ResponseEntity<String> deleteOrder(long id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+id+".json";

        return restTemplate.exchange(url,HttpMethod.DELETE,entity, String.class);
    }


}

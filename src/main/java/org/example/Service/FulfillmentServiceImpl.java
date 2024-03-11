package org.example.Service;

import org.example.DTO.FlfillmentDTOs.FulfillmentDTO;
import org.example.DTO.ShopifyRequests.FulfillmentHoldRequest;
import org.example.DTO.ShopifyRequests.FulfillmentMoveRequest;
import org.example.DTO.ShopifyRequests.FulfillmentShopifyRequest;
import org.example.DTO.FulfillmentRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FulfillmentServiceImpl implements FulfillmentService {

    @Value("${access_token}")
    String accessToken;
    @Value("${shop}")
    private String store;

    @Value("${locationId}")
    private Long locationId;

    public ResponseEntity<String> getAssignedOrders(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/assigned_fulfillment_orders.json?assignment_status=fulfillment_requested&location_ids[]="+locationId;
//
//        List<FulfillmentOrders> orders = restTemplate.getForObject(url,List.class);
//        for (FulfillmentOrders fo:orders){
//            System.out.println(fo);
//        }
//        return ResponseEntity.ok("hello");
        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    public ResponseEntity<String> acceptFulfilmentRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);

        String url = "https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/fulfillment_request/accept.json";

//        FulfillmentOrders fulfillmentOrders=restTemplate.postForObject(url,entity, FulfillmentOrders.class);
        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> rejectFulfillmentRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);

        String url = "https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/fulfillment_request/reject.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> acceptCancellationRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);

        String url = "https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/cancellation_request/accept.json";

//        FulfillmentOrders fulfillmentOrders=restTemplate.postForObject(url,entity, FulfillmentOrders.class);
        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> rejectCancellationRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);

        String url = "https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/cancellation_request/reject.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }



    public ResponseEntity<String> closeFulfillmentOrder(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);
        String url = "https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/close.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);

    }
    public ResponseEntity<String> getFulfillmentOrdrs(long orderId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+orderId+"/fulfillment_orders.json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }
    public ResponseEntity<String> createFulfillment(FulfillmentDTO fulfillmentDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillments.json";
        FulfillmentShopifyRequest request = new FulfillmentShopifyRequest(fulfillmentDTO);
        HttpEntity<FulfillmentShopifyRequest> entity = new HttpEntity<>(request,headers);

        return restTemplate.exchange(url, HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> requestFulfillment(long fulfilmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfilmentOrderId+"/fulfillment_request";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> requestCancellation(long fulfilmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentRequestDTO> entity = new HttpEntity<>(fulfillmentRequestDTO,headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfilmentOrderId+"/cancellation_request";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> getFulfillments(long orderId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/orders/"+orderId+"/fulfillments.json";

        return restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
    }

    public ResponseEntity<String> cancelFulfillment(long fulfillmentId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillments/"+fulfillmentId+"/cancel";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> cancelFulfillmentOrder(long fulfillmentOrderId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/cancel";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> holdOrder(long fulfillmentOrderId, FulfillmentHoldRequest fulfillmentHoldDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<FulfillmentHoldRequest> entity = new HttpEntity<>(fulfillmentHoldDTO,headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/hold.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

    public ResponseEntity<String> releaseHoldOrder(long fulfillmentOrderId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/release_hold.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }

        public ResponseEntity<String> moveOrder(long fulfillmentOrderId, FulfillmentMoveRequest fulfillmentMoveRequest){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Shopify-Access-Token",accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url="https://"+store+".myshopify.com/admin/api/2024-01/fulfillment_orders/"+fulfillmentOrderId+"/move.json";

        return restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
    }
}

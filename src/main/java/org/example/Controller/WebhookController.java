package org.example.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entity.Customer;
import org.example.Entity.Order;
import org.example.Entity.Product;


import org.example.Service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

   @Autowired
   private WebhookService webhookService;

    @PostMapping("/")
    public ResponseEntity<String> handleWebhook(@RequestHeader("X-Shopify-Topic") String topic,@RequestBody String data) throws JsonProcessingException {
        if(topic.startsWith("products")){
            webhookService.handleProducts(topic,data);
        }
        else if (topic.startsWith("customers")) {
            webhookService.handleCustomers(topic,data);
        }
        else if(topic.startsWith("orders")) {
            webhookService.handleOrders(topic,data);
        }
        return ResponseEntity.ok("received");
        }

}

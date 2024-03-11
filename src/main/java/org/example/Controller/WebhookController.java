package org.example.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;


import org.example.Service.WebhookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

   @Autowired
   private WebhookServiceImpl webhookServiceImpl;

    @PostMapping("/")
    public ResponseEntity<String> handleWebhook(@RequestHeader("X-Shopify-Topic") String topic,@RequestBody String data) throws JsonProcessingException {
        if(topic.startsWith("products")){
            webhookServiceImpl.handleProducts(topic,data);
        }
        else if (topic.startsWith("customers")) {
            webhookServiceImpl.handleCustomers(topic,data);
        }
        else if(topic.startsWith("orders")) {
            webhookServiceImpl.handleOrders(topic,data);
        }
        return ResponseEntity.ok("received");
        }

}

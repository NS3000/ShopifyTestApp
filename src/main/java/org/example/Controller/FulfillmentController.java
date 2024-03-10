package org.example.Controller;

import org.example.DTO.ShopifyRequests.FulfillmentHoldRequest;
import org.example.DTO.FulfillmentRequestDTO;
import org.example.DTO.ShopifyRequests.FulfillmentMoveRequest;
import org.example.Service.FulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillments")
public class FulfillmentController {

    @Autowired
    FulfillmentService fulfillmentService;

    @PostMapping("/requestFulfillment/{id}")
    public ResponseEntity<String> requestFulfillment(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.requestFulfillment(fulfillmentOrderId, fulfillmentRequestDTO);

    }

    @PostMapping("/requestCancellation/{id}")
    public ResponseEntity<String> requestFulfillmentCancellation(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.requestCancellation(fulfillmentOrderId, fulfillmentRequestDTO);

    }

    @GetMapping("/getFulfillments/{orderId}")
    public ResponseEntity<String> getFulfillments(@PathVariable("orderId") long orderId){
        return fulfillmentService.getFulfillments(orderId);
    }


    @PostMapping("/cancelFulfillmentOrder/{id}")
    public ResponseEntity<String> cancelFulfillmentOrder(@PathVariable("id") long fulfillmentOrderId){
        return fulfillmentService.cancelFulfillmentOrder(fulfillmentOrderId);
    }

    @GetMapping("/fulfillmentOrder/{orderId}")
    public ResponseEntity<String> getFulfillmentOrder(@PathVariable("orderId") long orderId){
        return fulfillmentService.getFulfillmentOrdrs(orderId);
    }

    @PostMapping("/holdOrder/{id}")
    public ResponseEntity<String> holdFulfillmentOrder(@PathVariable("id") long id, @RequestBody FulfillmentHoldRequest fulfillmentHoldDTO){
        return fulfillmentService.holdOrder(id,fulfillmentHoldDTO);
    }

    @PostMapping("/releaseHoldOrder/{id}")
    public ResponseEntity<String> releaseHoldFulfillmentOrder(@PathVariable("id") long id){
        return fulfillmentService.releaseHoldOrder(id);
    }

    @PostMapping("/moveOrder/{id}")
    public ResponseEntity<String> moveOrder(@PathVariable("id") long id, @RequestBody FulfillmentMoveRequest fulfillmentMoveRequest){
        return fulfillmentService.moveOrder(id, fulfillmentMoveRequest);
    }
}

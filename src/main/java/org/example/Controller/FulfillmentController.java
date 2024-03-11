package org.example.Controller;

import org.example.DTO.ShopifyRequests.FulfillmentHoldRequest;
import org.example.DTO.FulfillmentRequestDTO;
import org.example.DTO.ShopifyRequests.FulfillmentMoveRequest;
import org.example.Service.FulfillmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillments")
public class FulfillmentController {

    @Autowired
    FulfillmentServiceImpl fulfillmentServiceImpl;

    @PostMapping("/requestFulfillment/{id}")
    public ResponseEntity<String> requestFulfillment(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentServiceImpl.requestFulfillment(fulfillmentOrderId, fulfillmentRequestDTO);

    }

    @PostMapping("/requestCancellation/{id}")
    public ResponseEntity<String> requestFulfillmentCancellation(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentServiceImpl.requestCancellation(fulfillmentOrderId, fulfillmentRequestDTO);

    }

    @GetMapping("/getFulfillments/{orderId}")
    public ResponseEntity<String> getFulfillments(@PathVariable("orderId") long orderId){
        return fulfillmentServiceImpl.getFulfillments(orderId);
    }


    @PostMapping("/cancelFulfillmentOrder/{id}")
    public ResponseEntity<String> cancelFulfillmentOrder(@PathVariable("id") long fulfillmentOrderId){
        return fulfillmentServiceImpl.cancelFulfillmentOrder(fulfillmentOrderId);
    }

    @GetMapping("/fulfillmentOrder/{orderId}")
    public ResponseEntity<String> getFulfillmentOrder(@PathVariable("orderId") long orderId){
        return fulfillmentServiceImpl.getFulfillmentOrdrs(orderId);
    }

    @PostMapping("/holdOrder/{id}")
    public ResponseEntity<String> holdFulfillmentOrder(@PathVariable("id") long id, @RequestBody FulfillmentHoldRequest fulfillmentHoldDTO){
        return fulfillmentServiceImpl.holdOrder(id,fulfillmentHoldDTO);
    }

    @PostMapping("/releaseHoldOrder/{id}")
    public ResponseEntity<String> releaseHoldFulfillmentOrder(@PathVariable("id") long id){
        return fulfillmentServiceImpl.releaseHoldOrder(id);
    }

    @PostMapping("/moveOrder/{id}")
    public ResponseEntity<String> moveOrder(@PathVariable("id") long id, @RequestBody FulfillmentMoveRequest fulfillmentMoveRequest){
        return fulfillmentServiceImpl.moveOrder(id, fulfillmentMoveRequest);
    }
}

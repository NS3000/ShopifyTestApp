package org.example.Controller;

import org.example.DTO.FlfillmentDTOs.FulfillmentDTO;
import org.example.DTO.FulfillmentRequestDTO;
import org.example.Service.FulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fulfillmentService")
@CrossOrigin("*")
public class FulfillmentServiceController {

    @Autowired
    FulfillmentService fulfillmentService;

    @GetMapping("/assignedOrders")
    public ResponseEntity<String> getAssignedOrders(){
        return fulfillmentService.getAssignedOrders();
//        return ResponseEntity.ok("got assigned orders");
    }

    @PostMapping("/acceptFulfillmentRequest/{id}")
    public ResponseEntity<String> acceptFulfillmentRequest(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.acceptFulfilmentRequest(fulfillmentOrderId, fulfillmentRequestDTO);
    }

    @PostMapping("/rejectFulfillmentRequest/{id}")
    public ResponseEntity<String> rejectFulfillmentRequest(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.rejectFulfillmentRequest(fulfillmentOrderId, fulfillmentRequestDTO);
    }

    @PostMapping("/acceptCancellationRequest/{id}")
    public ResponseEntity<String> acceptCancellationRequest(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.acceptCancellationRequest(fulfillmentOrderId, fulfillmentRequestDTO);
    }

    @PostMapping("/rejectCancellationRequest/{id}")
    public ResponseEntity<String> rejectCancellationRequest(@PathVariable("id") long fulfillmentOrderId, @RequestBody FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.rejectCancellationRequest(fulfillmentOrderId, fulfillmentRequestDTO);
    }

    @PostMapping("/closeFulfillmentOrder/{id}")
    public ResponseEntity<String> closeFulfillment(@PathVariable("id") long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO){
        return fulfillmentService.closeFulfillmentOrder(fulfillmentOrderId, fulfillmentRequestDTO);
    }

    @PostMapping("/createFulfillment")
    public ResponseEntity<String> createFulfillment(@RequestBody FulfillmentDTO fulfillmentDTO){
        return fulfillmentService.createFulfillment(fulfillmentDTO);

    }

    @PostMapping("/cancelFulfillment/{id}")
    public ResponseEntity<String> cancelFulfillment(@PathVariable("id") long fulfillmentId){
        return fulfillmentService.cancelFulfillment(fulfillmentId);
    }


}

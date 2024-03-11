package org.example.Service;

import org.example.DTO.FlfillmentDTOs.FulfillmentDTO;
import org.example.DTO.FulfillmentRequestDTO;
import org.example.DTO.ShopifyRequests.FulfillmentHoldRequest;
import org.example.DTO.ShopifyRequests.FulfillmentMoveRequest;
import org.springframework.http.ResponseEntity;

public interface FulfillmentService {

    public ResponseEntity<String> getAssignedOrders();
    public ResponseEntity<String> acceptFulfilmentRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> rejectFulfillmentRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> acceptCancellationRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> rejectCancellationRequest(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> closeFulfillmentOrder(Long fulfillmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> getFulfillmentOrdrs(long orderId);
    public ResponseEntity<String> createFulfillment(FulfillmentDTO fulfillmentDTO);
    public ResponseEntity<String> requestFulfillment(long fulfilmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> requestCancellation(long fulfilmentOrderId, FulfillmentRequestDTO fulfillmentRequestDTO);
    public ResponseEntity<String> getFulfillments(long orderId);
    public ResponseEntity<String> cancelFulfillment(long fulfillmentId);
    public ResponseEntity<String> cancelFulfillmentOrder(long fulfillmentOrderId);
    public ResponseEntity<String> holdOrder(long fulfillmentOrderId, FulfillmentHoldRequest fulfillmentHoldDTO);
    public ResponseEntity<String> releaseHoldOrder(long fulfillmentOrderId);
    public ResponseEntity<String> moveOrder(long fulfillmentOrderId, FulfillmentMoveRequest fulfillmentMoveRequest);

}

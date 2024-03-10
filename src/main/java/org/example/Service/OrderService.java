package org.example.Service;

import org.example.DTO.OrderRequestDTO;
import org.example.DTO.OrderUpdateRequestDTO;
import org.example.DTO.FulfillmentRequestDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface OrderService {
    public ResponseEntity<String> getAllOrders();
    public ResponseEntity<String> addOrder(OrderRequestDTO orderRequestDTO) throws IOException;
    public ResponseEntity<String> cancelOrder(long id);
    public ResponseEntity<String> getOrder(long id);
    public ResponseEntity<String> editOrder(long id, OrderUpdateRequestDTO updateRequestDTO);
    public ResponseEntity<String> deleteOrder(long id);
}

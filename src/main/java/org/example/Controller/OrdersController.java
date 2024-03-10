package org.example.Controller;

import org.example.DTO.OrderRequestDTO;
import org.example.DTO.OrderUpdateRequestDTO;
import org.example.DTO.FulfillmentRequestDTO;
import org.example.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable("id") long id){
        return orderService.getOrder(id);
    }
    @GetMapping("/list")
    public ResponseEntity<String> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderRequestDTO order) throws IOException {
        return orderService.addOrder(order);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id){
        return orderService.cancelOrder(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editOrders(@PathVariable("id") long id,@RequestBody OrderUpdateRequestDTO updateRequestDTO){
        return orderService.editOrder(id,updateRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order Deleted Successfully!");
    }


}

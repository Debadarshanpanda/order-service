package org.example.controller;

import org.example.dto.OrderRequestDto;
import org.example.dto.OrderResponseDto;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderservice;

    @PostMapping("/add")
    public ResponseEntity<OrderResponseDto>  createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderservice.createOrder(orderRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>>  getAllOrder(){
        return new ResponseEntity<>(orderservice.getAllOrders(),HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<OrderResponseDto> fetchOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderservice.getOrderById(id),HttpStatus.OK);
    }

}

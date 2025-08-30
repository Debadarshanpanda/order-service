package org.example.service;

import org.example.dto.OrderRequestDto;
import org.example.dto.OrderResponseDto;
import org.example.entity.Order;
import org.example.exception.UserNotFoundException;
import org.example.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderRequestDto,order);
        Order savedOrder = repository.save(order);
        OrderResponseDto responseDto = new OrderResponseDto();
        BeanUtils.copyProperties(savedOrder,responseDto);
        return responseDto;
    }
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = repository.findAll();
        return orders.stream().map(order -> {
            OrderResponseDto dto = new OrderResponseDto();
            BeanUtils.copyProperties(order, dto);
            return dto;
        }).collect(Collectors.toList());
    }
    public OrderResponseDto getOrderById(Long orderId){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        Order order = repository.findById(orderId).orElseThrow(()->new UserNotFoundException("order not found with given id " + orderId));
        BeanUtils.copyProperties(order,orderResponseDto);
        return orderResponseDto;

    }



}

package org.example.controller;

import org.example.dto.OrderRequestDto;
import org.example.dto.OrderResponseDto;
import org.example.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private OrderRequestDto requestDto;
    private OrderResponseDto responseDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDto = new OrderRequestDto();
        requestDto.setName("Laptop");
        requestDto.setDescription("HP");

        responseDto = new OrderResponseDto();
        responseDto.setOrderId(1L);
        responseDto.setName("Laptop");
        responseDto.setDescription("HP");
    }

    @Test
    public void testCreateOrder() {
        when(orderService.createOrder(requestDto)).thenReturn(responseDto);

        ResponseEntity<OrderResponseDto> response = orderController.createOrder(requestDto);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Laptop", response.getBody().getName());
        verify(orderService, times(1)).createOrder(requestDto);
    }

    @Test
    public void testGetAllOrders() {
        List<OrderResponseDto> mockList = Arrays.asList(responseDto);
        when(orderService.getAllOrders()).thenReturn(mockList);

        ResponseEntity<List<OrderResponseDto>> response = orderController.getAllOrder();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        verify(orderService, times(1)).getAllOrders();
    }

    @Test
    public void testFetchOrderById() {
        when(orderService.getOrderById(1L)).thenReturn(responseDto);

        ResponseEntity<OrderResponseDto> response = orderController.fetchOrderById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getOrderId());
        verify(orderService, times(1)).getOrderById(1L);
    }
}


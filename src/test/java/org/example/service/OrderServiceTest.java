/*
package org.example.service;

import org.example.dto.OrderRequestDto;
import org.example.dto.OrderResponseDto;
import org.example.entity.Order;
import org.example.exception.UserNotFoundException;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    Service orderService;

    private OrderRequestDto requestDto;
    private Order order;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        requestDto = new OrderRequestDto();
        requestDto.setName("Laptop");
        requestDto.setDescription("HP");

        order = new Order();
        order.setOrderId(1L.save(any(Order.class))).thenReturn(order);

        OrderResponseDto result = orderService.createOrder(requestDto);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));

        List<OrderResponseDto> result = orderService.getAllOrders();

        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testGetOrderById_Found() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        OrderResponseDto result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getOrderId());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetOrderById_NotFound() {
        when(orderRepository.findById(2L)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            orderService.getOrderById(2L);
        });

        assertEquals("order not found with given id 2", exception.getMessage());
        verify(orderRepository, times(1)).findById(2L);
    }
}
*/

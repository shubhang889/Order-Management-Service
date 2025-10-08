package org.example.controller;

import org.example.model.dto.OrderRequest;
import org.example.model.dto.OrderResponse;
import org.example.model.dto.UpdateStatusRequest;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public OrderResponse createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderDetails(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/all")
    public List<OrderResponse> getAllOrders(@RequestParam(required = false) List<String> orderIds) {
        return orderService.getAllOrders(orderIds);
    }

    @PutMapping("/{orderId}/status")
    public OrderResponse updateStatus(@PathVariable String orderId, @RequestBody UpdateStatusRequest request){
        return orderService.updateStatus(orderId, request);
    }
}

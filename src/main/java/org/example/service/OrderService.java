package org.example.service;

import org.example.model.dto.OrderRequest;
import org.example.model.dto.OrderResponse;
import org.example.model.dto.UpdateStatusRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderResponse createOrder (OrderRequest request);
    OrderResponse getOrder(String orderId);
    List<OrderResponse> getAllOrders(List<String> orderIds);
    OrderResponse updateStatus(String orderId, UpdateStatusRequest request);
}

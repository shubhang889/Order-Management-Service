package org.example.service;

import org.example.exception.OrderNotFoundException;
import org.example.model.dao.Order;
import org.example.model.dao.OrderItem;
import org.example.model.dto.OrderRequest;
import org.example.model.dto.OrderResponse;
import org.example.model.dto.UpdateStatusRequest;
import org.example.model.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Map<String, Order> orderStore = new ConcurrentHashMap<>();

    @Override
    public OrderResponse createOrder(OrderRequest request) throws IllegalArgumentException {
        if (request == null || request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        List<OrderItem> items = request.getItems().stream()
                .map(i -> new OrderItem(
                        Objects.requireNonNull(i.getProductId(), "productId is required"),
                        Objects.requireNonNull(i.getProductName(), "product name is required"),
                        i.getQuantity(),
                        i.getPrice()
                )).toList();

        Order order = new Order(items);
        orderStore.put(order.getOrderId(), order);

        return new OrderResponse(order.getOrderId(), order.getStatus().toString(), order.getItems());
    }

    @Override
    public OrderResponse getOrder(String orderId) {
        Order order = orderStore.getOrDefault(orderId, null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        return new OrderResponse(order.getOrderId(), order.getStatus().toString(), order.getItems());
    }

    @Override
    public List<OrderResponse> getAllOrders(List<String> orderIds) {
        if (orderIds == null || orderIds.isEmpty()) {
            return orderStore.values().stream()
                    .map(order -> new OrderResponse(order.getOrderId(), order.getStatus().toString(), order.getItems()))
                    .collect(Collectors.toList());
        }
        return orderIds.stream()
                .map(orderStore::get)
                .filter(Objects::nonNull)
                .map(order -> new OrderResponse(order.getOrderId(), order.getStatus().toString(), order.getItems()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse updateStatus(String orderId, UpdateStatusRequest request) {
        String status = request.getStatus();
        Order order = orderStore.getOrDefault(orderId, null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        order.setStatus(OrderStatus.valueOf(status));
        orderStore.put(orderId, order);

        return OrderResponse.builder()
                .orderId(order.getOrderId())
                .items(order.getItems())
                .status(order.getStatus().name())
                .build();
    }
}

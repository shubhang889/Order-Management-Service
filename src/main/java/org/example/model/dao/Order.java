package org.example.model.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.model.enums.OrderStatus;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order {
    String orderId;
    List<OrderItem> items;
    ZonedDateTime createdAt;
    ZonedDateTime updatedAt;
    OrderStatus status;

    public Order(List<OrderItem> items) {
        this.items = items;
        orderId = UUID.randomUUID().toString();
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
        status = OrderStatus.CREATED;
    }

//    public Integer getTotalAmount(List<OrderItem> items) {
//        int total = 0;
//        return items.forEach(item -> {
//            total+=item.getQuantity() * item.getPrice();
//        });
//    }
}




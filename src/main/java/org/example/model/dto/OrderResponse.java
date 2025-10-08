package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.model.dao.OrderItem;

import java.time.ZonedDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {
    String orderId;
    String status;
//    Double totalAmount;
    List<OrderItem> items;
}

package org.example.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
    String productId;
    String productName;
    int quantity;
    double price;
}

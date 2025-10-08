package org.example.model.dto;

import java.util.*;

import lombok.Getter;
import lombok.Setter;
import org.example.model.dao.OrderItem;

@Getter
@Setter
public class OrderRequest {
    List<OrderItem> items;
}

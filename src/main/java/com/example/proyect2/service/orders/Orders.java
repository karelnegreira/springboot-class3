package com.example.proyect2.service.orders;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Set;

public class Orders {
}


interface OrderRepository extends ListCrudRepository<Order, Integer> { }

@Table("orders_line_item")
record LineItem (Integer id, int product, int quantity) { }

@Table("orders")
record Order (Integer id, Set<LineItem> lineItem) { }

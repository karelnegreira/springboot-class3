package com.example.proyect2.service.orders;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class Orders {
}

@Controller
@ResponseBody
class OrdersController {

    private final OrderRepository repository;

    OrdersController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    void create(@RequestBody Order order) {

    }
}


interface OrderRepository extends ListCrudRepository<Order, Integer> { }

@Table("orders_line_item")
record LineItem (Integer id, int product, int quantity) { }

@Table("orders")
record Order (Integer id, Set<LineItem> lineItem) { }

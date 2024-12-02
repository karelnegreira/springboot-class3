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
        var saved = this.repository.save(order);
        System.out.println("Saved [ "  + saved + " ]");
    }
}
//features of java 21, object oriented
//sealed classes
//records
// matching patterns
//smart switch expressions

sealed interface Loan permits SecuredLoan, UnsecuredLoan {}

class Loans {
    String DisplayessageFor(Loan loan) {
        var message = "";
        if (loan instanceof SecuredLoan) {
            var sl = (SecuredLoan) loan;
            message = "Congrats you got the loan";
        }
        if (loan instanceof UnsecuredLoan) {
            var usl = (UnsecuredLoan) loan;
            message = "The interest " + usl.interest() + " % is high";
        }

        return message;
    }
}

final class SecuredLoan implements Loan { }

//records are tuples
 record UnsecuredLoan(float interest) implements Loan { }


interface OrderRepository extends ListCrudRepository<Order, Integer> { }

@Table("orders_line_item")
record LineItem (Integer id, int product, int quantity) { }

@Table("orders")
record Order (Integer id, Set<LineItem> lineItem) { }

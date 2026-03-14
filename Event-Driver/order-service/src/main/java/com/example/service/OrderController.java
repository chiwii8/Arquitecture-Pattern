package com.example.service;

import com.example.OrderProducer.OrderProducer;
import com.example.events.OrderCreatedEvents;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * OrderController.java
 * <p>
 * Description: Controller that receives the event to create an order
 *
 * @author aleja
 * @since 06/03/2026
 */

@RestController
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody OrderCreatedEvents order){

        order.setOrderId(UUID.randomUUID().toString());

        this.orderProducer.sendOrderEvent(order);

        return "Order created and event published!";
    }
}

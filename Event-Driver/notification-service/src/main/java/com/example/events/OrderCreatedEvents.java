package com.example.events;

import lombok.Getter;
import lombok.Setter;

/**
 * OrderCreatedEvents.java
 *
 * Description: Order created based in events
 *
 * @author aleja
 * @since 06/03/2026
 */

@Getter
@Setter
public class OrderCreatedEvents {
    private String orderId;
    private String product;
    private int quantity;
    private String email;

    public OrderCreatedEvents(){}

    public OrderCreatedEvents(String orderId, String product, int quantity, String email) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.email = email;
    }

}

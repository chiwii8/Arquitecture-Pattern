package com.example.service;

import com.example.events.OrderCreatedEvents;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consume(OrderCreatedEvents event) {

        System.out.println("📦 Order received!");
        System.out.println("OrderId: " + event.getOrderId());
        System.out.println("Product: " + event.getProduct());
        System.out.println("Email notification sent to: " + event.getEmail());
    }
}
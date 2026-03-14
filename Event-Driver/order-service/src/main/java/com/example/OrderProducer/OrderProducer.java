package com.example.OrderProducer;

import com.example.events.OrderCreatedEvents;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * OrderProducer.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 06/03/2026
 */

@Service
public class OrderProducer {
        private final KafkaTemplate<String, OrderCreatedEvents> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderCreatedEvents> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderCreatedEvents events){
        this.kafkaTemplate.send("order-topic",events);
    }
}

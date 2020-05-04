package br.com.kafka.study.consumer;

import br.com.kafka.study.consumer.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.order.group-id}")
    public void consumer(final ConsumerRecord<String, Order> consumerRecord) throws IOException {
        log.info("Object Order {}", consumerRecord.toString());
        log.info("Order: {}", consumerRecord.value());
    }
}

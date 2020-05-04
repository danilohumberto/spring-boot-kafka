package br.com.kafka.study.consumer;

import br.com.kafka.study.consumer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomerConsumer {

    @KafkaListener(topics = "${customer.topic}", groupId = "${spring.kafka.consumer.customer.group-id}")
    public void consumer(final ConsumerRecord<String, Customer> consumerRecord) throws IOException {
        log.info("Object Customer {}", consumerRecord.toString());
        log.info("Customer: {}", consumerRecord.value());
    }
}

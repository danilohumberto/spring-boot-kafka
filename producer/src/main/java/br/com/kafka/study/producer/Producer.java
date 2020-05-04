package br.com.kafka.study.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topicName, final @RequestBody String data) {
        kafkaTemplate.send(topicName, UUID.randomUUID().toString(), data);
    }

}

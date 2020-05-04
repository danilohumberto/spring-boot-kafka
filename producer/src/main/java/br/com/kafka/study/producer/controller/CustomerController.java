package br.com.kafka.study.producer.controller;

import br.com.kafka.study.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
@Slf4j
public class CustomerController {

    @Value("${customer.topic}")
    private String TOPIC;

    private final Producer producer;

    public CustomerController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String data) {
        producer.send(TOPIC, data);
    }
}

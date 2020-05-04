package br.com.kafka.study.consumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonSerialize
public class Order implements Serializable {

    private String identifier;
    private String customer;
    private BigDecimal value;

    public Order() {
        super();
    }

    public Order(String identifier, String customer, BigDecimal value) {
        this.identifier = identifier;
        this.customer = customer;
        this.value = value;
    }
}

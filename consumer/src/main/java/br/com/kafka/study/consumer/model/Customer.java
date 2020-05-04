package br.com.kafka.study.consumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@JsonSerialize
public class Customer implements Serializable {

    private String identifier;
    private String name;
    private BigDecimal lastName;

    public Customer() {
        super();
    }

    public Customer(String identifier, String name, BigDecimal lastName) {
        this.identifier = identifier;
        this.name = name;
        this.lastName = lastName;
    }
}

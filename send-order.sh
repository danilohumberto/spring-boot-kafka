#!/bin/bash

######## CURL NO TOPIC ORDERS ########
data='"identifier": "5eb02de159c4ec9bec16b6f7","customer": "Rosemarie Anthony","value": 55'
url=http://localhost:8080/orders

curl -d "$data" -H "Content-Type: application/json" -X POST ${url}

######## CURL NO TOPIC CUSTOMERS ########
data='"identifier": "5eb02de159c4ec9bec16b6f7","name": "Danilo","lastName": "Oliveira"'
url=http://localhost:8080/customers

curl -d "$data" -H "Content-Type: application/json" -X POST ${url}
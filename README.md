# spring-boot-kafka

## Pré requisitos

- Maven 3+
- Java 8+
- Docker 18.02.0+ 

## Preparando ambiente

- Execute o `docker-compose up` para inicializar o Zookeeper e Kafka.
- Execute `mvn clean package` na pasta do projeto para realizar o build das aplicações.

## Executando 

- Inicialize o projeto `producer`
````
cd producer
mvn spring-boot:run
````

Obs: a aplicação Producer disponibiliza o endpoint `POST http://localhost:8080/orders` para receber os eventos dos pedidos.


-  Inicialize o projeto `consumer`
````
cd consumer
mvn spring-boot:run
````
Obs: O projeto do consumer não tem endpoint, ele apenas conecta no tópico do Kafka para escutar o stream.


## Executando 


Para testar, pode ser utilizado o seguinte comando: `./send-order.sh "{\"identifier\": \"12343\",\"customer\": \"Customer X\", \"value\": 1500}"`, onde será inserido o pedido no tópico do Kafka, via a aplicação `producer`, e será cosumido pela aplicação `consumer`, como no log abaixo:
````
2020-05-04 16:15:36.288  INFO 11876 --- [ntainer#1-0-C-1] b.c.kafka.study.consumer.OrderConsumer   : Object Order ConsumerRecord(topic = orderTopic, partition = 0, offset = 11, CreateTime = 1588619736281, serialized key size = 36, serialized value size = 96, headers = RecordHeaders(headers = [], isReadOnly = false), key = 321e7a03-7386-4ecd-a604-ba921a34af2a, value = "identifier": "5eb02de159c4ec9bec16b6f7","customer": "Rosemarie Anthony","value": 55)
2020-05-04 16:15:36.289  INFO 11876 --- [ntainer#1-0-C-1] b.c.kafka.study.consumer.OrderConsumer   : Order: "identifier": "5eb02de159c4ec9bec16b6f7","customer": "Rosemarie Anthony","value": 55
2020-05-04 16:15:36.321  INFO 11876 --- [ntainer#0-0-C-1] b.c.k.study.consumer.CustomerConsumer    : Object Customer ConsumerRecord(topic = customerTopic, partition = 0, offset = 11, CreateTime = 1588619736317, serialized key size = 36, serialized value size = 94, headers = RecordHeaders(headers = [], isReadOnly = false), key = 35afca02-ac24-4c7b-bc2d-adf0f88bbdd2, value = "identifier": "5eb02de159c4ec9bec16b6f7","name": "Danilo","lastName": "Oliveira")
2020-05-04 16:15:36.321  INFO 11876 --- [ntainer#0-0-C-1] b.c.k.study.consumer.CustomerConsumer    : Customer: "identifier": "5eb02de159c4ec9bec16b6f7","name": "Danilo","lastName": "Oliveira"
````

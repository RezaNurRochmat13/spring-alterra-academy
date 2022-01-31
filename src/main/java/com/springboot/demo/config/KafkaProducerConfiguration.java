package com.springboot.demo.config;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {
    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaBootstrapAddress;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, String> producerMap = new HashMap<String, String>();
        producerMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapAddress);
        producerMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, String.valueOf(StringSerializer.class));
        producerMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, String.valueOf(StringSerializer.class));

        return new DefaultKafkaProducerFactory(producerMap);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

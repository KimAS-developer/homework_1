package com.example.weather_producer.config;

import com.example.weather_producer.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, Weather> producerFactory(
            ObjectMapper objectMapper
    ) {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        JsonSerializer<Weather> weatherSerializer = new JsonSerializer<>(objectMapper);
        weatherSerializer.setAddTypeInfo(false);

        return new DefaultKafkaProducerFactory<>(
                configProperties,
                new StringSerializer(),
                weatherSerializer
        );
    }

    @Bean
    public KafkaTemplate<String, Weather> kafkaTemplate(
            ProducerFactory<String, Weather> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }
}

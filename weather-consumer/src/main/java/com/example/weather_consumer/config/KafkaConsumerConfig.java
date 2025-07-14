package com.example.weather_consumer.config;

import com.example.weather_consumer.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, Weather> consumerFactory(
            ObjectMapper objectMapper
    ) {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "weather-group");
        JsonDeserializer<Weather> weatherDeserializer = new JsonDeserializer<>(Weather.class, objectMapper);

        return new DefaultKafkaConsumerFactory<>(
                configProperties,
                new StringDeserializer(),
                weatherDeserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Weather> containerFactory(
            ConsumerFactory<String, Weather> consumerFactory
    ) {
        var containerFactory = new ConcurrentKafkaListenerContainerFactory<String, Weather>();
        containerFactory.setConcurrency(1);
        containerFactory.setConsumerFactory(consumerFactory);

        return containerFactory;
    }
}

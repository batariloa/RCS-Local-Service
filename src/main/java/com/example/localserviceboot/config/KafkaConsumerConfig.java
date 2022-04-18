package com.example.localserviceboot.config;

import com.example.localserviceboot.model.Command;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;



    public Map<String, Object> consumerConfig(){

        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();

        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put("com.example.serviceremoteredirect.model.Command", Command.class);
        typeMapper.setIdClassMapping(classMap);

        typeMapper.addTrustedPackages("*");

        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.serviceremoteredirect.model");
        props.put(JsonDeserializer.TYPE_MAPPINGS, "command: com.example.localserviceboot.model.Command");
        return  props;
    }



    public ConsumerFactory<String, Command> userConsumerFactory() {


        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public KafkaTemplate<String, Command> kafkaTemplate(
            ProducerFactory<String, Command> producerFactory
    ){
        return new KafkaTemplate<>(producerFactory);
    }

    public KafkaListenerContainerFactory<
            ConcurrentMessageListenerContainer<String, Command>> factory(
            ConsumerFactory<String, Command> consumerFactory
    ){
        ConcurrentKafkaListenerContainerFactory<String,Command > factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory);

        return factory;

    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Command> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Command> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }



}

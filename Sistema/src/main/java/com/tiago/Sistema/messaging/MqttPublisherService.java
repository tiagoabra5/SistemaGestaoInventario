package com.tiago.Sistema.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiago.Sistema.dto.SaleEventDTO;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {

    private final MqttClient mqttClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${mqtt.topic.sale}")
    private String saleTopic;

    public MqttPublisherService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(SaleEventDTO event) {
        try {
            objectMapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            String payload = objectMapper.writeValueAsString(event);
            MqttMessage message = new MqttMessage(payload.getBytes());
            message.setQos(1);
            mqttClient.publish(saleTopic, message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao publicar no MQTT", e);
        }
    }
}
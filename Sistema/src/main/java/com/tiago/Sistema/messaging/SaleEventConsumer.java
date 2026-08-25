package com.tiago.Sistema.messaging;

import com.tiago.Sistema.dto.SaleEventDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SaleEventConsumer {

    private final MqttPublisherService mqttPublisherService;

    public SaleEventConsumer(MqttPublisherService mqttPublisherService) {
        this.mqttPublisherService = mqttPublisherService;
    }

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void handleSaleEvent(SaleEventDTO event) {
        System.out.println("Evento recebido do RabbitMQ: " + event.getProductName());
        mqttPublisherService.publish(event);
        System.out.println("Evento publicado no MQTT, tópico: inventory/sales");
    }
}
package com.cibertec.cita.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.cibertec.cita.config.RabbitMQConfig;

@Component
public class CitaProducer {

	private final RabbitTemplate rabbitTemplate;

	public CitaProducer(
			RabbitTemplate rabbitTemplate) {

		this.rabbitTemplate = rabbitTemplate;
	}

	public void enviarEvento(String mensaje) {

		rabbitTemplate.convertAndSend(
				RabbitMQConfig.EXCHANGE,
				RabbitMQConfig.ROUTING_KEY,
				mensaje);
	}
}
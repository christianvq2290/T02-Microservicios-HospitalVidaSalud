package com.cibertec.cita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

@Configuration
public class RabbitMQConfig {

	public static final String EXCHANGE =
			"cita.exchange";

	public static final String NOTIFICACION_QUEUE =
			"notificacion.queue";

	public static final String AUDITORIA_QUEUE =
			"auditoria.queue";

	public static final String ROUTING_KEY =
			"cita.creada";

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Queue notificacionQueue() {
		return new Queue(NOTIFICACION_QUEUE);
	}

	@Bean
	public Queue auditoriaQueue() {
		return new Queue(AUDITORIA_QUEUE);
	}

	@Bean
	public Binding bindingNotificacion() {
		return BindingBuilder
				.bind(notificacionQueue())
				.to(exchange())
				.with(ROUTING_KEY);
	}

	@Bean
	public Binding bindingAuditoria() {
		return BindingBuilder
				.bind(auditoriaQueue())
				.to(exchange())
				.with(ROUTING_KEY);
	}
}
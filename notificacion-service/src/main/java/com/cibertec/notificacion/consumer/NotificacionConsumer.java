package com.cibertec.notificacion.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionConsumer {

	@RabbitListener(queues = "notificacion.queue")
	public void recibirMensaje(String mensaje) {

		System.out.println(
			"NOTIFICACION RECIBIDA: "
				+ mensaje);
	}
}
package com.cibertec.auditoria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaConsumer {

	@RabbitListener(queues = "auditoria.queue")
	public void recibirMensaje(String mensaje) {

		System.out.println(
			"AUDITORIA RECIBIDA: "
				+ mensaje);
	}
}
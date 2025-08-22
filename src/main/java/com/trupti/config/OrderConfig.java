package com.trupti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trupti.domain.port.output.OrderJpaRepositoryPort;
import com.trupti.domain.service.OrderService;

@Configuration
public class OrderConfig {
	
	@Bean
	public OrderService orderService(OrderJpaRepositoryPort repoPort) {
		return new OrderService(repoPort);
	}
}

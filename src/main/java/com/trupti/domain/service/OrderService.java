package com.trupti.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.trupti.domain.dto.FoodOrder;
import com.trupti.domain.port.input.PlaceOrderUsecase;
import com.trupti.domain.port.input.TrackOrderUsecase;
import com.trupti.domain.port.output.OrderJpaRepositoryPort;

public class OrderService implements PlaceOrderUsecase, TrackOrderUsecase{

	@Autowired
	private final OrderJpaRepositoryPort orderRepo;
	
	public OrderService (OrderJpaRepositoryPort port) {
		this.orderRepo = port;
	}
	
	@Override
	public String trackOrder(String orderId) {
		System.out.println("----Executed from Service ----");
		return orderRepo.findById(orderId);
	}

	@Override
	public void placeOrder(FoodOrder order) {
		System.out.println("----EXECUTED from service----");
		order.setStatus("ORDER PLACED");
		orderRepo.saveOrder(order);
	}

}

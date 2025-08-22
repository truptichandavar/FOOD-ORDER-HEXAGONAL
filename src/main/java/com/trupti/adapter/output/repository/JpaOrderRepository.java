package com.trupti.adapter.output.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.trupti.adapter.output.entity.OrderEntity;
import com.trupti.domain.dto.FoodOrder;
import com.trupti.domain.port.output.OrderJpaRepositoryPort;

@Repository("jpaOrderRepository")
//@Qualifier("jpaOrderRepository")
public class JpaOrderRepository implements OrderJpaRepositoryPort {

	@Autowired
	private SpringDataOrderRepository repo;
	
	
	@Override
	public void saveOrder(FoodOrder order) {
		System.out.println("----CORE EXECUTED WITH OUTPUT Adapter  ---- placeOrder");
		repo.save(mapToEntity(order));
		
	}

	@Override
	public String findById(String orderId) {
		System.out.println("----CORE EXECUTED WITH INPUT PORT  ---- trackOrder");
		OrderEntity oe = repo.getById(orderId);
		return mapToDto(oe).getStatus();
	}
	
	
	private OrderEntity mapToEntity(FoodOrder order) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(order.getOrderId());
		entity.setCustomerName(order.getCustomerName());
		entity.setRestaurantName(order.getRestaurantName());
		entity.setItem(order.getItem());
		entity.setStatus(order.getStatus());
		return entity;
	}
	
	private FoodOrder mapToDto(OrderEntity entity) {
		FoodOrder order = new FoodOrder();
		order.setOrderId(entity.getOrderId());
		order.setCustomerName(entity.getCustomerName());
		order.setRestaurantName(entity.getRestaurantName());
		order.setItem(entity.getItem());
		order.setStatus(entity.getStatus());
		return order;
	}

}

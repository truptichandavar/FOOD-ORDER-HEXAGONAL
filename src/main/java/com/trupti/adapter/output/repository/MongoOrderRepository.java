package com.trupti.adapter.output.repository;

import org.springframework.stereotype.Component;

import com.trupti.domain.dto.FoodOrder;
import com.trupti.domain.port.output.OrderMongoDBRepositoryPort;

@Component("mongoOrderRepository")
//@Qualifier("mongoOrderRepository")
//@Primary
public class MongoOrderRepository implements OrderMongoDBRepositoryPort{

	@Override
	public void saveOrder(FoodOrder order) {
		// Add save order logic here
		
	}

	@Override
	public String findById(String orderId) {
		//Add MongoDB logic here
		System.out.println("tracking order from output adapter mongo db");
		return "ORDER STUCK";
	}

}

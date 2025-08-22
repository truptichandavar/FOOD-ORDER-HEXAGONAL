package com.trupti.domain.port.output;

import com.trupti.domain.dto.FoodOrder;

public interface OrderJpaRepositoryPort {
	
	void saveOrder(FoodOrder order);
	String findById(String orderId);

}

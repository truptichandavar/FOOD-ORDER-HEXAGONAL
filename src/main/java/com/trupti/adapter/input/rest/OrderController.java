package com.trupti.adapter.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trupti.domain.dto.FoodOrder;
import com.trupti.domain.port.input.PlaceOrderUsecase;
import com.trupti.domain.port.input.TrackOrderUsecase;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final PlaceOrderUsecase placeOrderUsecase;
	private final TrackOrderUsecase trackOrderUsecase;
	
	public OrderController(PlaceOrderUsecase placeOrder, TrackOrderUsecase trackOrder) {
		this.placeOrderUsecase = placeOrder;
		this.trackOrderUsecase = trackOrder;
	}
	
	
	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestBody FoodOrder order){
		System.out.println("----INPUT ADAPTER EXECUTED (REST) ----");
		placeOrderUsecase.placeOrder(order);
		return ResponseEntity.ok("Order placed");
	}
	
	@GetMapping("/track/{orderId}")
	public ResponseEntity<String> trackOrder(@PathVariable String orderId){
		System.out.println("----INPUT ADAPTER EXECUTED (trackOrder) ----");
		return ResponseEntity.ok("Status: "+trackOrderUsecase.trackOrder(orderId));
	}

}

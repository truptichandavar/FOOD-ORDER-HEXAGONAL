package com.trupti.adapter.output.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.trupti.adapter.output.entity.OrderEntity;


public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String>{

}

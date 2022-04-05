package com.example.demo.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class OrderService {

	final private OrderRepository orderRepository;

	public Mono<Order> pendingAnOrder() {
		Order newOrder = new Order();
		newOrder.setId(UUID.randomUUID());
		newOrder.setCreatedBy("test-user");
		return orderRepository.save(newOrder);
	}

	public Flux<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}

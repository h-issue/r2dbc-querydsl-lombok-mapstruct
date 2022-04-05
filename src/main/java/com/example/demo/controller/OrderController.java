package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/order")
@RestController
@AllArgsConstructor
public class OrderController {

	final private OrderService orderService;

	@GetMapping("/pendingAnOrder")
	public Mono<Order> pendingAnOrder() {
		return orderService.pendingAnOrder();
	}

	@GetMapping("/getAllOrders")
	public Flux<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

}

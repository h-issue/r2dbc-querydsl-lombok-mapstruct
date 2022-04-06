package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domain.Order;

public interface OrderRepository extends ReactiveCrudRepository<Order, UUID> {
}
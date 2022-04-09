package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.core.Uid;
import com.example.demo.domain.Order;

public interface OrderRepository extends ReactiveCrudRepository<Order, Uid> {
}
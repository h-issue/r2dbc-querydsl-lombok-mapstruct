package com.example.demo.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.H2ConnectionConfig;
import com.example.demo.domain.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.OrderMapperImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.test.StepVerifier;

@ExtendWith({ SpringExtension.class })
@Import({ H2ConnectionConfig.class })
@SpringBootTest(classes = { OrderMapperImpl.class })
@Slf4j
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Test
	void testSave() {
		UUID id = UUID.randomUUID();
		Order newOrder = new Order();
		newOrder.setId(id);
		newOrder.setCreatedBy("test-user");

		var persisted = orderRepository.save(newOrder) //
				.doOnNext(it -> log.debug("new order saved: {}", it)) //
				.map(a -> orderRepository.findById(a.getId()))//
				.flatMap(a -> a.map(b -> b.getId()));

		StepVerifier.create(persisted) //
				.expectNext(id) //
				.verifyComplete();
	}

	@Test
	void testMapper() {
		UUID id = UUID.randomUUID();
		String createdBy = "test-dto";
		Order newOrder = new Order();
		newOrder.setId(id);
		newOrder.setCreatedBy(createdBy);

		var persisted = orderRepository.save(newOrder) //
				.doOnNext(it -> log.debug("new order saved: {}", it)) //
				.flatMap(a -> orderRepository.findById(a.getId())) //
				.map(o -> orderMapper.toDTO(o));

		StepVerifier.create(persisted) //
				.expectNextMatches(p -> p.getCreatedBy().equals(createdBy)) //
				.verifyComplete();
	}
}

package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import com.example.demo.config.R2dbcConfiguration;
import com.example.demo.core.Uid;
import com.example.demo.domain.Order;
import com.example.demo.mapper.OrderMapper;
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepositoriesAutoConfiguration;

import lombok.extern.slf4j.Slf4j;
import reactor.test.StepVerifier;

@Slf4j
@DataR2dbcTest
@ImportAutoConfiguration(classes = { QuerydslR2dbcRepositoriesAutoConfiguration.class, R2dbcConfiguration.class })
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

	@Test
	void testSave() {
		Uid id = Uid.getUid();
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
		Uid id = Uid.getUid();
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

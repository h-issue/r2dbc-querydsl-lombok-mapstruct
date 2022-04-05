package com.example.demo.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import com.example.demo.domain.User;
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepositoriesAutoConfiguration;

import lombok.extern.slf4j.Slf4j;
import reactor.test.StepVerifier;

@Slf4j
@DataR2dbcTest
@ImportAutoConfiguration(classes = { QuerydslR2dbcRepositoriesAutoConfiguration.class })
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void testSave() {
		UUID id = UUID.randomUUID();
		User newOrder = new User();
		newOrder.setId(id);
		newOrder.setName("test-user");

		var persisted = userRepository.save(newOrder) //
				.doOnNext(it -> log.debug("new user saved: {}", it)) //
				.map(a -> userRepository.findById(a.getId()))//
				.flatMap(a -> a.map(b -> b.getId()));

		StepVerifier.create(persisted) //
				.expectNext(id) //
				.verifyComplete();
	}

}

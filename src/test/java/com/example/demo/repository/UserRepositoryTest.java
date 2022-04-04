package com.example.demo.repository;

import static com.example.demo.domain.QUser.user;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.H2ConnectionConfig;
import com.example.demo.domain.User;

import lombok.extern.slf4j.Slf4j;
import reactor.test.StepVerifier;

@ExtendWith({ SpringExtension.class })
@Import({ H2ConnectionConfig.class })
@Slf4j
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void testSave() {
		UUID id = UUID.randomUUID();
		User newUser = new User();
		newUser.setId(id);
		newUser.setName("test-user");

		var persisted = userRepository.save(newUser) //
				.doOnNext(it -> log.debug("new user saved: ", it)) //
				.map(u -> userRepository //
						.query(query -> query //
								.select(user.getProjection()) //
								.where(user.id.eq(id))) //
						.one() //
				) //
				.flatMap(uu -> uu.map(uuu -> uuu.getId()));

		StepVerifier.create(persisted) //
				.expectNext(id) //
				.verifyComplete();
	}
}

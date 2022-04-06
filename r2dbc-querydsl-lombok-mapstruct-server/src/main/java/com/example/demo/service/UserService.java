package com.example.demo.service;

import static com.example.demo.domain.QUser.user;

import org.springframework.stereotype.Service;

import com.example.demo.core.Uid;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserService {

	final private UserRepository userRepository;

	public Mono<User> pendingAUser() {
		User newUser = new User();
		newUser.setId(Uid.getUid());
		newUser.setName("test-user");
		return userRepository.save(newUser);
	}

	public Flux<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Flux<User> getUsersByName(final String likeString) {
		return userRepository.query(query -> query //
				.select(user) //
				.from(user) //
				.where(user.name.like("%" + likeString + "%")) //
				.limit(10)) //
				.all();
	}
}

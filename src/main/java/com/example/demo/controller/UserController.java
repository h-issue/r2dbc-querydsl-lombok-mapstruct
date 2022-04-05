package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/api/user")
@RestController
@AllArgsConstructor
public class UserController {

	final private UserService userService;

	@GetMapping("/pendingAUser")
	public Mono<User> pendingAUser() {
		return userService.pendingAUser();
	}

	@GetMapping("/getAllUsers")
	public Flux<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getUsersByName/{likeString}")
	public Flux<User> getUsersByName(@PathVariable final String likeString) {
		return userService.getUsersByName(likeString);
	}

}

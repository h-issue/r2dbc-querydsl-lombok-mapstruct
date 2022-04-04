package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domain.User;

// ReactiveCrudRepository is working, but QuerydslR2dbcRepository is not.
public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
// public interface UserRepository extends QuerydslR2dbcRepository<User, UUID> {
}
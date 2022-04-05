package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.domain.User;
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository;

// ReactiveCrudRepository is working, but QuerydslR2dbcRepository is not.
//public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
public interface UserRepository extends QuerydslR2dbcRepository<User, UUID> {
}
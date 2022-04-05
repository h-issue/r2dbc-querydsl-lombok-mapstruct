package com.example.demo.domain;

import java.time.LocalDateTime;

import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @MappedSuperclass
public abstract class BaseDomain {

	@Column("created_at")
	private LocalDateTime createdAt;
	@Column("updated_at")
	private LocalDateTime updatedAt;

}
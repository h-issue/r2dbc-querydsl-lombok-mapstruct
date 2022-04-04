package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("t_order")
public class Order implements Persistable<UUID> {

	@Id
	private UUID id;
	private String createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Override
	public boolean isNew() {
		return createdAt == null;
	}
}
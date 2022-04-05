package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("t_user")
public class User implements Persistable<UUID> {

	@Id
	@Column("id")
	private UUID id;
	@Column("name")
	private String name;
	@Column("created_at")
	private LocalDateTime createdAt;
	@Column("updated_at")
	private LocalDateTime updatedAt;

	@Override
	public boolean isNew() {
		return createdAt == null;
	}
}
package com.example.demo.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.core.Uid;

import lombok.Data;

@Data
@Table("t_user")
public class User implements Persistable<Uid> {

	public User(Uid id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, boolean newEntity) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.newEntity = newEntity;
	}

	@PersistenceConstructor
	public User(Uid id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.newEntity = false;
	}

	@Id
	@Column("id")
	private Uid id;

	@Column("name")
	private String name;

	@Column("created_at")
	private LocalDateTime createdAt;

	@Column("updated_at")
	private LocalDateTime updatedAt;

//	@Override
//	public boolean isNew() {
//		return createdAt == null;
//	}

	@Transient
	private boolean newEntity;

	@Override
	public boolean isNew() {
		return this.newEntity || createdAt == null;
	}

	public User setAsNew() {
		this.newEntity = true;
		return this;
	}
}
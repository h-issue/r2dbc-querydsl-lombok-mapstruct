package com.example.demo.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table("t_user")
@QueryEntity
public class User extends BaseDomain implements Persistable<UUID> {

	@Id
	@Column("id")
	private UUID id;
	@Column("name")
	private String name;

	@Override
	public boolean isNew() {
		return getCreatedAt() == null;
	}
}
package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.core.Uid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table("t_order")
//@QueryEntity
public class Order extends BaseDomain implements Persistable<Uid> {

	@Id
	@Column("id")
	private Uid id;

	@Column("created_by")
	private String createdBy;

	@Transient
	private boolean newEntity;

	@Override
	public boolean isNew() {
		return this.newEntity || getCreatedAt() == null;
	}

	public Order setAsNew() {
		this.newEntity = true;
		return this;
	}
}
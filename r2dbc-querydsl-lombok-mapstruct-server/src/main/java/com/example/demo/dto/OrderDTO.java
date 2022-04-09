package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.core.Uid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Uid id;
	private String createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
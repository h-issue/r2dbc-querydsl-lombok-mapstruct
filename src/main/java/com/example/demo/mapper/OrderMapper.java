package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.demo.domain.Order;
import com.example.demo.dto.OrderDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	public Order toDomain(OrderDTO source);

	public OrderDTO toDTO(Order source);

}

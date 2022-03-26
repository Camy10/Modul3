package com.application.modul3.order.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.order.Order;
import com.application.modul3.order.dto.OrderCreateDTO;
import com.application.modul3.order.dto.OrderDTO;
import com.application.modul3.order.dto.OrderWithCustomerIdDTO;

@Component
public class OrderMapper {
	
	public Order orderCreateDTO2Order(OrderCreateDTO orderCreateDTO) {
		Order order = new Order();
		order.setDate(orderCreateDTO.getDate());
		order.setPaid(orderCreateDTO.getPaid());
		order.setTotalPrice(orderCreateDTO.getTotalPrice());
		
		return order;		
	}
	
	public OrderDTO order2OrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setPaid(order.getPaid());
		orderDTO.setDate(order.getDate());
		orderDTO.setTotalPrice(order.getTotalPrice());
		//orderDTO.setCustomerId(order.getCustomer().getId());
		return orderDTO;	
	}

	public Order orderDTO2Order(OrderDTO orderDTO) {
		Order order = new Order();
		order.setDate(orderDTO.getDate());
		order.setId(orderDTO.getId());
		order.setPaid(orderDTO.getPaid());
		order.setTotalPrice(orderDTO.getTotalPrice());
		return order;
	}

	public List<OrderDTO> listOrder2ListOrderDTO(List<Order> allOrder) {
		return allOrder.stream()
		.map(order -> order2OrderDTO(order))
		.collect(Collectors.toList());
		
	}

}

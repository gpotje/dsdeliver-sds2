package com.gpotje.dsdeliver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpotje.dsdeliver.DTO.OrderDTO;
import com.gpotje.dsdeliver.entities.Order;
import com.gpotje.dsdeliver.repository.OrderRepository;

@Service
public class OrderService {

		@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
		
		
	}
	
	
}

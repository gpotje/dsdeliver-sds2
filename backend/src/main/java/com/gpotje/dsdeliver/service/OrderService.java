package com.gpotje.dsdeliver.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpotje.dsdeliver.DTO.OrderDTO;
import com.gpotje.dsdeliver.DTO.ProductDTO;
import com.gpotje.dsdeliver.entities.Order;
import com.gpotje.dsdeliver.entities.OrderStatus;
import com.gpotje.dsdeliver.entities.Product;
import com.gpotje.dsdeliver.repository.OrderRepository;
import com.gpotje.dsdeliver.repository.ProductRepository;

@Service
public class OrderService {

		@Autowired
	private OrderRepository orderRepository;
		
		@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
		
		
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
	 Order order = new Order(null,
			 dto.getAddress(),
			 dto.getLatitude(),
			 dto.getLongitude(),
			 Instant.now(),
			 OrderStatus.PENDING);
	 
	 //percorre todos os produtos associados
	 for(ProductDTO p : dto.getProduct()) {
		 Product product = productRepository.getOne(p.getId());
		 order.getProducts().add(product);
	 }
	 order = orderRepository.save(order);
	 return new OrderDTO(order);
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}

package com.gpotje.dsdeliver.service;

import java.util.List;

import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpotje.dsdeliver.DTO.ProductDTO;
import com.gpotje.dsdeliver.entities.Product;
import com.gpotje.dsdeliver.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	//como a operação e de leitura fica mais rapido
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = productrepository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x))
				.collect(Collectors.toList());
		
	}
	
	

}

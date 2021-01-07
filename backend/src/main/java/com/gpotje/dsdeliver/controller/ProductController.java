package com.gpotje.dsdeliver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotje.dsdeliver.DTO.ProductDTO;
import com.gpotje.dsdeliver.service.ProductService;

@RestController
@RequestMapping(value ="/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		List<ProductDTO> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	
	
	
}

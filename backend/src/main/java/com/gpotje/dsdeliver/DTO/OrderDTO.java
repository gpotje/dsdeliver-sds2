package com.gpotje.dsdeliver.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gpotje.dsdeliver.entities.Order;
import com.gpotje.dsdeliver.entities.OrderStatus;

public class OrderDTO implements Serializable{
	
 	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	
	private List<ProductDTO> product = new ArrayList<>();
	
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}


	public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	public OrderDTO(Order obj) {
		
		id = obj.getId();
		address = obj.getAddress();
		latitude = obj.getLatitude();
		longitude = obj.getLongitude();
		moment = obj.getMoment();
		status = obj.getStatus();
		product = obj.getProducts().stream().map(x -> new ProductDTO(x))
				.collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public List<ProductDTO> getProduct() {
		return product;
	}
	
	
	

}

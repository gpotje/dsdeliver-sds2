package com.gpotje.dsdeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpotje.dsdeliver.entities.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}

package com.example.servingwebcontent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
	List<Basket> findAll();
	List<Basket> findBySessionid(String sessionid);
}

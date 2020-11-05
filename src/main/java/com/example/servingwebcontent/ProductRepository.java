package com.example.servingwebcontent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
	author: jeff ayllon
	date: November 2, 2020
*/
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findAll();
}

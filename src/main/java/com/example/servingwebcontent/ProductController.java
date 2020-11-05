package com.example.servingwebcontent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
	author: jeff ayllon
	date: November 2, 2020
*/
@Controller	
@RequestMapping(path="/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(path="/addall")
	public @ResponseBody String addall(){
		productRepository.save(new Product("nikeblueshirtmen.jpg","Nike Blue Shirt", 700));
		productRepository.save(new Product("nikegreenshoes.jpg","Nike Green Shoes", 800));
		productRepository.save(new Product("nikeblueshoes.jpg","Nike Blue Shoes", 900));
		return "addall success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> list(){
		List<Product> products = productRepository.findAll();
		return products;
	}
}

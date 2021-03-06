package com.example.servingwebcontent;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
	author: jeff ayllon
	date: November 2, 2020
*/
@Controller
public class HomeController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BasketRepository basketRepository;
	
	public int getTotal(List<Basket> baskets) {
		int total = 0;
		if(baskets.size() > 0) {
			for(Basket b: baskets) {
				total += b.getPrice();
			}
		}
		return total;
	}
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		List<Product> products = productRepository.findAll();
		
		List<Basket> baskets = basketRepository.findBySessionid(session.getId());
		
		int total = getTotal(baskets);
		
		model.addAttribute("products", products);
		model.addAttribute("baskets", baskets);
		model.addAttribute("total", total);
		
		System.out.println("session: " + session.getId());
		return "home";
	}
	
	@GetMapping("/add")
	public String add(
			@RequestParam(name = "productid", required = true) int productid,
			@RequestParam(name = "imagessrc", required = true) String imagessrc,
			@RequestParam(name = "details", required = true) String details,
			@RequestParam(name = "price", required = true) int price,
			Model model, HttpSession session) 
	{
		basketRepository.save(new Basket(session.getId(), productid, imagessrc, details, price));
		
		List<Product> products = productRepository.findAll();
		List<Basket> baskets = basketRepository.findBySessionid(session.getId());
		
		int total = getTotal(baskets);		
		
		model.addAttribute("products", products);
		model.addAttribute("baskets", baskets);
		model.addAttribute("total", total);
		
		return "home";
	}
	@GetMapping("/remove")
	public String remove(
			@RequestParam(name = "basketid", required = true) int basketid,
			Model model, HttpSession session) 
	{
		basketRepository.deleteById(basketid);
		
		List<Product> products = productRepository.findAll();
		List<Basket> baskets = basketRepository.findBySessionid(session.getId());
		
		int total = getTotal(baskets);
		
		model.addAttribute("products", products);
		model.addAttribute("baskets", baskets);
		model.addAttribute("total", total);
		
		return "home";
	}
}

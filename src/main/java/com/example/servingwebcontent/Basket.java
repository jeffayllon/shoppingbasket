package com.example.servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Basket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String sessionid;
	private Integer productid;
	private String image;
	private String details;
	private Integer price;
	
	public Basket() {
	}
	public Basket(String sessionid, int productid, String image, String details, int price) {
		this.sessionid = sessionid;
		this.productid = productid;
		this.image = image;
		this.details = details;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}

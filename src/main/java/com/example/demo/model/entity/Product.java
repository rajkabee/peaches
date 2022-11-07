package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String sku;
	private String name;
	private String manufacturer;
	private String description;
	private BigDecimal unitPrice;
	private int unitsInStock;
	private boolean isActive;
	@CreationTimestamp
	private Date dateCreated;
	@UpdateTimestamp
	private Date dateUpdated;
	private String imageUrl;
	@ManyToMany
	private List<Category> categories;

	public Product(String sku, String name, String manufacturer, String description, BigDecimal unitPrice,
			int unitsInStock, boolean isActive, String imageUrl, ArrayList<Category> categories) {
		super();
		this.sku = sku;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", manufacturer=" + manufacturer
				+ ", description=" + description + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock
				+ ", isActive=" + isActive + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
				+ ", imageUrl=" + imageUrl + ", categories=" + categories + "]";
	}
	
	
	

	
	
	
	
	
}

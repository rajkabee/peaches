package com.example.demo.controllers.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repositories.ProductRepository;

@RestController

public class ProductRestController {
	@Autowired
	ProductRepository productRepo;
	
	@RequestMapping("/productsByCategory")
	public List<Product> productsByCategoryId(@RequestParam("categoryId") long id) {
		return productRepo.findByCategoriesIdOrderByDescriptionAsc(id);
	}
}

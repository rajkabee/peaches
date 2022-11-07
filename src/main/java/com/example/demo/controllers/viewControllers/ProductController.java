package com.example.demo.controllers.viewControllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repositories.CategoryRepository;
import com.example.demo.model.repositories.ProductRepository;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/{catId}")
	public String getProductsByCategoryId(@PathVariable("catId") long catId, Model model) {
		List<Category> catList = catRepo.findAll();
		model.addAttribute("categories",catList);
		Pageable page = PageRequest.of(0, 20);
		//List<Product> products = productRepo.findByCategoryId(catId, page);
		//model.addAttribute("products",products);
		return "productsByCategory";
	}
	
	
	
	
	@GetMapping("/add")
	public String addProductForm(Model model ) {
		List<Category> catList = catRepo.findAll();
		model.addAttribute("categories",catList);
		return "productForm";
	}
	
	
	
	
	
	@PostMapping("/add")
	public String addProduct(
				@RequestParam("category") String categoryId,
				@RequestParam("name") String name,
				@RequestParam("manufacturer") String manufacturer,
				@RequestParam("description") String description,
				@RequestParam("sku") String sku,
				@RequestParam("unitPrice") BigDecimal unitPrice,
				@RequestParam("image") MultipartFile file,
				@RequestParam("active") Boolean isActive,
				@RequestParam("unitsInStock") int unitsInStock,
				HttpServletRequest request
				
			) throws IOException {
		Category category = catRepo.findById(Long.parseLong(categoryId)).get();
		if (!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			//String destPath = new ClassPathResource("/static/images").getFile().getAbsolutePath();
			String destPath = new ClassPathResource("/static/assets/images/products/").getFile().getAbsolutePath();
			System.out.println(destPath);
			try {
				Files.copy(file.getInputStream(), Paths.get(destPath+File.separator+file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
			}
		}
		//System.out.println(categoryId);
		ArrayList<Category> categories = new ArrayList<>();
		categories.add(category);
		Product product = new Product(sku,
				name, manufacturer, description, unitPrice, unitsInStock, isActive,
				"assets/images/products/"+file.getOriginalFilename(),
				categories);
		productRepo.save(product);
		return "redirect:/products/add";
	}
	
}

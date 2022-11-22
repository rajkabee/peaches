package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
@Configuration

public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	@Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Product.class);
        config.exposeIdsFor(Category.class);
        
    }
	

}

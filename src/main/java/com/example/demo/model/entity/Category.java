package com.example.demo.model.entity;

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
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	
	@CreationTimestamp
	private Date dateCreated;
	@UpdateTimestamp
	private Date dateUpdated;
	
	@ManyToMany
	List<Product> products;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}
	
	
}

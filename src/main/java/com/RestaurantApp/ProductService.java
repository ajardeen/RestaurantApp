package com.RestaurantApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	public void Psave(Products p) {
		prepo.save(p);
	}
	public List<Products> pfindAll()
	{
		return prepo.findAll();
	}
	
	public void pdelete(int id) {
		prepo.deleteById(id);
	}
	
	public Products pfindid(int id) {
		return prepo.findById(id).orElse(null);
	}
}

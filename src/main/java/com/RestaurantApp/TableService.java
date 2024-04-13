package com.RestaurantApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

	@Autowired
	private TableRepository trepo;
	
	public List<Tables> findall(){
	return	trepo.findAll();
	}
}

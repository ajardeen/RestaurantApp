package com.RestaurantApp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDataService {
	
	@Autowired
	private LoginDataRepository loginrepo;
	
	public void save(LoginData log) {
		loginrepo.save(log);
	}
	
	
	public LoginData findid(int id) {
		return loginrepo.findById(id).orElse(null);
	}
	
	public List<LoginData> findall(){
		return loginrepo.findAll();
		}
	public void delete(int id) {
		loginrepo.deleteById(id);
	}

	/*
	 * public List<LoginData> allUser(){ return loginrepo.getUserName(); }
	 */
}

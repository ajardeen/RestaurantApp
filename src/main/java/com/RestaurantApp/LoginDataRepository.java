package com.RestaurantApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDataRepository extends JpaRepository<LoginData, Integer> {

	/*
	 * @Query("select USERNAME from logindata USERNAME") public List<LoginData>
	 * getUserName();
	 */
	
}

package com.example.pro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pro.Model.Customer;

@Repository
	public interface CustomerRepo extends JpaRepository<Customer, Long> {
	  
	}


package com.example.pro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pro.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}

	
package com.example.swagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swagger.Model.User;



public interface UserRepo extends JpaRepository<User,Integer>{

}

package com.example.day5.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day5.Model.HotelModel;

public interface HotelRepo extends JpaRepository<HotelModel,Integer>{

}
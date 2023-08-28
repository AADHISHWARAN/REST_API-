package com.example.swagger.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.Model.User;
import com.example.swagger.Repository.UserRepo;



@Service
public class UserService<hrepo> {
	
	@Autowired
	public UserRepo hrepo;
	
	//post the data
	public String saveHotel(User h)
	{
		hrepo.save(h);
		return "Data is saved to database";
	}
	
	//get the data
	
	public List<User> getHotel()
	{
		return hrepo.findAll();
	}
	
	//update the data(put)
	
	public User updateHotel(User hm)
	{
		return hrepo.saveAndFlush(hm);
	}
	public boolean deleteHotelif(int gardenId)
	{
		if(hrepo.existsById(gardenId))
		{
			hrepo.deleteById(gardenId);
			return true;
		}
		return false;
	}
	
	//delete the data
	public void deleteHotel(int garden_id)
	{
		System.out.println("Deleted");
		hrepo.deleteById(garden_id);
	}
	public Optional<User> getUserId(int userId)
	{
		Optional<User> hotel=hrepo.findById(userId);
		if(hotel.isPresent())
		{
			return hotel;
		}
		return null;
	}

}

package com.example.swagger.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.Model.User;
import com.example.swagger.Service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
public class UserController {
	
	@Autowired
	public UserService<?> hserv;
	
	//post mapping
	
	@PostMapping("/postHotel")
	@Tag(name="POST Users",description="Post user details here")
	public String postHotel(@RequestBody User hr)
	{
		hserv.saveHotel(hr);
		return "Data is saved to the Database";
	}
	
	//get mapping
	
	@GetMapping("/getHotel")
	@Tag(name="GET Users",description="all user details here")
	public List<User> getHotelInfo()
	{
		return hserv.getHotel();
	}
	
	//put mapping
	
	@PutMapping("/updateHotel")
	@Tag(name="PUT Users",description="Put user details here")
	public User updateHotelInfo(@RequestBody User ha)
	{
		return hserv.updateHotel(ha);
	}
	@DeleteMapping("/DeleteHotelif/{id}")
	@Tag(name="DELETE Users",description="delete user by id  details here")
	public ResponseEntity<String> deleteHotelInfo(@PathVariable int id)
	{
		boolean deleted = hserv.deleteHotelif(id);
		
		if(deleted)
		{
			return ResponseEntity.ok("Hotel with ID " + id + " deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID " + id + " not found");
		}
	}
	@DeleteMapping("/deleteHotel/{id}")
	@Tag(name="DELETE Users",description="delete user  id details here")
	public String deleteHotel(@PathVariable("id") int hid)
	{
		hserv.deleteHotel(hid);
		return "Hotel with Id "+hid+" id deleted";
	}
	
	//delete mapping using request parm
	

	@DeleteMapping("/byReqParm")
	@Tag(name="DELETE Users",description="delete  user id details here")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hserv.deleteHotel(id);
		return "Hotel with Id "+id+" id deleted";
	}
	//getUserById
	
		@GetMapping("/users/(userId)")

		public ResponseEntity<?> getUserbyId(@PathVariable int userId)
		{
			Optional<User> hotel = hserv.getUserId(userId);
			if(hotel != null)
			{
				return ResponseEntity.ok(hotel);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
		}

}

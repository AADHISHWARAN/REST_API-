package com.example.day5.Controller;


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

import com.example.day5.Model.HotelModel;
import com.example.day5.Service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	public HotelService<?> hserv;
	
	//post mapping
	
	@PostMapping("/postHotel")
	public String postHotel(@RequestBody HotelModel hr)
	{
		hserv.saveHotel(hr);
		return "Data is saved to the Database";
	}
	
	//get mapping
	
	@GetMapping("/getHotel")
	public List<HotelModel> getHotelInfo()
	{
		return hserv.getHotel();
	}
	
	//put mapping
	
	@PutMapping("/updateHotel")
	public HotelModel updateHotelInfo(@RequestBody HotelModel ha)
	{
		return hserv.updateHotel(ha);
	}
	@DeleteMapping("/DeleteHotelif/{id}")
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
	public String deleteHotel(@PathVariable("id") int hid)
	{
		hserv.deleteHotel(hid);
		return "Hotel with Id "+hid+" id deleted";
	}
	
	//delete mapping using request parm
	

	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hserv.deleteHotel(id);
		return "Hotel with Id "+id+" id deleted";
	}
	//getUserById
	
		@GetMapping("/users/(userId)")
		public ResponseEntity<?> getUserbyId(@PathVariable int userId)
		{
			Optional<HotelModel> hotel = hserv.getUserId(userId);
			if(hotel != null)
			{
				return ResponseEntity.ok(hotel);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
		}

}

package com.example.day4;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
     	@GetMapping("sh")
     	public String Welcome()
     	{
     		return "Welcome";
     	}
}

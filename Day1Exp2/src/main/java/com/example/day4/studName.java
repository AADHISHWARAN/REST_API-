package com.example.day4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studName {
	   @GetMapping("/get")
	    public String getName() {
	        String studentName = "Iamneo"; 
	        return "Welcome " + studentName + "!";
	    }
}

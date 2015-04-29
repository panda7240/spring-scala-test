package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;

@RestController
public class SampleController {

	@RequestMapping(value = "/", method = {RequestMethod.GET})
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
	
	@RequestMapping(value = "/getUser", method = {RequestMethod.GET})
	@ResponseBody
	public User getUser() {
		User user = new User("x", 10, false);
		return user;
	}

	
}

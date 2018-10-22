package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TuserService;

@RestController
@RequestMapping("/hello")
public class TestController {
	@Resource
	private TuserController tuserController;
	
	@GetMapping("/world")
	public String helloworld() {
		String user = tuserController.getUser();
		System.out.println(user);
		return "hellowo";
	}
}
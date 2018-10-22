package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Tuser;
import com.example.demo.service.TuserService;

@Controller
@RequestMapping("/tuser")
public class TuserController {
	@Resource
	private TuserService tuerService;
 
	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser() {
		List<Tuser> users = tuerService.getAllUser();
		return users.toString();
	}
}

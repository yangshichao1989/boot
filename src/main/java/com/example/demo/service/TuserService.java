package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Tuser;

public interface TuserService {
	List<Tuser> getAllUser();

	Integer seve(Tuser tuser);
}
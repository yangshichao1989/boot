package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Tuser;
@Repository
public interface TuserDao {
	List<Tuser> getAllUser();

	Integer seve(Tuser tuser);
}

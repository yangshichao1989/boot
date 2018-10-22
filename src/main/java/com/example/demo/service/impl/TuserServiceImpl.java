package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.RedisUtil;
import com.example.demo.dao.TuserDao;
import com.example.demo.model.Tuser;
import com.example.demo.service.TuserService;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class TuserServiceImpl implements TuserService {
	@Resource
	private TuserDao tuserDao;
	@Resource
	private RedisUtil tedisUtil;
 
	@Override
	public List<Tuser> getAllUser() {
//		RedisTemplate<String,String> redisTem =new RedisTemplate<String,String>();
		List<Tuser> allUser = tuserDao.getAllUser();
		tedisUtil.set("tusr",allUser);
		List<Tuser> list = (List<Tuser>)tedisUtil.get("tusr");
		return list;
	}
	@Override
	public Integer seve(Tuser tuser) {
		tuserDao.seve(tuser);
		
		return tuserDao.seve(tuser);
	}
 
}

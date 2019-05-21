package com.chenglu.springboot.demo.web.service.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenglu.springboot.demo.web.entity.TblUser;
import com.chenglu.springboot.demo.web.repository.TblUserRepo;
import com.chenglu.springboot.demo.web.service.TblUserService;

@Service
@Transactional
public class TblUserServiceImpl implements TblUserService {
	@Autowired
	private TblUserRepo repo;

	@Override
	public void save(TblUser user) throws Exception {
		repo.save(user);
	}
	
	
	
	
}

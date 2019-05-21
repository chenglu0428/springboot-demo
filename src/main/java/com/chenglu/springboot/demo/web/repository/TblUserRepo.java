package com.chenglu.springboot.demo.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.chenglu.springboot.demo.web.entity.TblUser;

@Repository
public interface TblUserRepo extends JpaRepository<TblUser, String>, JpaSpecificationExecutor<TblUser> {

}

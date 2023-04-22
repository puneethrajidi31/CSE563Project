package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.telusko.demo.model.Timeentry;

@Repository
public interface Database extends JpaRepository<Timeentry,Long> {
	List<Timeentry> findAll();
}


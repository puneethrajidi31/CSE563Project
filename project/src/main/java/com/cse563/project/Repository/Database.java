package com.cse563.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cse563.project.Model.Timeentry;

@Repository
public interface Database extends CrudRepository<Timeentry,Long> {
	List<Timeentry> findAll();
}

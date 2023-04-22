package com.telusko.demo.dao;

import com.telusko.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepo extends CrudRepository<User,Integer>
{
}

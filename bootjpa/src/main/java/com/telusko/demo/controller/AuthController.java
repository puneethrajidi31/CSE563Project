package com.telusko.demo.controller;

import com.telusko.demo.model.User;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.demo.Service.Emailservice;
import com.telusko.demo.dao.AuthRepo;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController
{
	@Autowired
	AuthRepo repo;
	int otpx=0;
	boolean manager=false;
	
	@Autowired
	Emailservice emailservice;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/addUser")
	public String addUser(User alien)
	{
		for (User user : repo.findAll()) {
			  if(alien.getEmailId().equals(user.getEmailId()))
				  return "alreadyRegistered.jsp";
		    }
			if(alien.getPassword().equals(alien.getReEnteredPassword())){
			repo.save(alien);
			return "login.jsp";}
			else {
		    return "Errorhandling.jsp";
		    }
	}

	@RequestMapping("/loginUser")
	public ModelAndView loginUser(User val)
	{
		ModelAndView mvAdmin=new ModelAndView("welcomeAdmin.jsp");
		ModelAndView mvEmployee=new ModelAndView("welcomeEmployee.jsp");
		ModelAndView mvError=new ModelAndView("Errorhandling.jsp");
		ModelAndView mvOtp=new ModelAndView("otp.jsp");
		for (User user : repo.findAll()) {
			if(user.getEmailId().equals(val.getEmailId()) && user.getPassword().equals(val.getPassword())){
				
				String subject = "Second Factor Authentication Code";
			    int x=new Random().nextInt(900000) + 100000;
			    otpx=x;
			    String content = "Hello User. Your one time password is "+x;
			    try {
			        emailservice.sendEmail(val.getEmailId(), subject, content);
			    } catch (UnsupportedEncodingException | MessagingException e) {
			        System.out.println(e.getStackTrace());
			    }
			    
			    if(user.getRole().equals("Manager"))
			    {
			    	manager=true;
			    }
			    else
			    {
			    	manager=false;
			    }
			    System.out.println(manager+ "first step");
			    
			    return mvOtp;
				
			}
		}
		return mvError;
	}
	
	@RequestMapping("/addOTP")
	public ModelAndView addOTP(@RequestParam String otpfromUser)
	{ 	ModelAndView mvAdmin=new ModelAndView("welcomeAdmin.jsp");
	    ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");
	    ModelAndView mvErr=new ModelAndView("Errorhandling.jsp");
        int x=Integer.parseInt(otpfromUser);  
        System.out.println(manager+ "Second step");
        if(x==otpx)
        	if(manager==true)
        		return mvAdmin;
        	else
        		return mvEmp;
        else
        	return mvErr;
		
	}


}

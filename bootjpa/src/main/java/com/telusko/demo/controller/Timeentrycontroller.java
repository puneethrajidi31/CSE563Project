package com.telusko.demo.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.Service.Emailservice;
import com.telusko.demo.dao.AuthRepo;
import com.telusko.demo.dao.Database;
import com.telusko.demo.model.Recipientemail;
import com.telusko.demo.model.Timeentry;
import com.telusko.demo.model.User;



@CrossOrigin
@RequestMapping("")
@RestController

public class Timeentrycontroller {

@Autowired	
private Database database;

@Autowired
private Emailservice emailservice;

@Autowired
AuthRepo repo;
int otpx=0;
String customerid="";
boolean manager=false;

Long xy;

@RequestMapping("/starttimer")
public ModelAndView shiftentry(Timeentry timeentry)
{   	
	ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");	
	Date starttime = new Date();
	//System.out.println("Step1");
	timeentry.setStartdate(starttime);
	timeentry.setAcceptance("Not yet submitted");
	Timeentry timeentry1=database.save(timeentry);
	xy=timeentry1.getId();
	return mvEmp;
}

@RequestMapping("/modify")
public ModelAndView ModifyTimeSlot(Timeentry timeentry)
{
	Long x=timeentry.getId();
	boolean y=database.existsById(x);
	if(y==false)
	{
		ModelAndView mvEmp=new ModelAndView("error.jsp");
		return mvEmp;
	}
	Timeentry c=database.findById(x).get();
	c.setProjectname(timeentry.getProjectname());
	c.setPlan(timeentry.getPlan());
	c.setLifecyclestep(timeentry.getLifecyclestep());
	c.setEffortcategory(timeentry.getEffortcategory());
	database.save(c);
	ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");
	return mvEmp;
	
}

@RequestMapping("/delete")
public ModelAndView DeleteTimeSlot(Timeentry timeentry)
{
	Long x=timeentry.getId();
	boolean y=database.existsById(x);
	if(y==false)
	{
		ModelAndView mvEmp=new ModelAndView("error.jsp");
		return mvEmp;
	}
	database.deleteById(x);
	ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");
	return mvEmp;
	
}

@RequestMapping("/endtimer")
public ModelAndView completeentry(Timeentry timeentry)
{
	ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");	
	Date endtime=new Date();
	Timeentry x=database.findById(xy).get();
	timeentry.setStartdate(x.getStartdate());
    timeentry.setEnddate(endtime);
    timeentry.setId(xy);
    timeentry.setAcceptance("Approval Pending");
    timeentry.setUsername(customerid);
    database.save(timeentry);
	return mvEmp;
}

@RequestMapping("/approve")
public ResponseEntity<?> approveslot(Timeentry timeentry)
{
	timeentry.setAcceptance("Approved");
	database.save(timeentry);
	return new ResponseEntity<String>("Time Slot is Approved",HttpStatus.OK);
}

@RequestMapping("/reject")
public void rejectslot(Timeentry timeentry)
{
	database.deleteById(timeentry.getId());
}
	
@RequestMapping("/fetchrecords")
public ModelAndView displayentries()
{
	ModelAndView mvRecords=new ModelAndView("Showrecords.jsp");
	List<Timeentry>p=database.findAll();
	List<Timeentry>q=p.stream().filter(x->x.getUsername().equals(customerid)).collect(Collectors.toList());
	if(q.size()==0)
	{
		return new ModelAndView("Nodata.jsp");
	}
	mvRecords.addObject("records", q);
	return mvRecords;
}

@PostMapping("/secondfactorauthentication")
public ResponseEntity<?> Authenticate(@RequestBody Recipientemail recipient)
{
    String subject = "Second Factor Authentication Code";
    int x=new Random().nextInt(900000) + 100000;
    String content = "Hello User. Your one time password is "+x;
    System.out.println(recipient);
    try {
        emailservice.sendEmail(recipient.getRecipientmail(), subject, content);
    } catch (UnsupportedEncodingException | MessagingException e) {
        System.out.println(e.getStackTrace());
    }
    return new ResponseEntity<Integer>(x,HttpStatus.CREATED);
}

@RequestMapping("/addOTP")
public ModelAndView addOTP(@RequestParam String otpfromUser)
{ 	ModelAndView mvAdmin=new ModelAndView("welcomeAdmin.jsp");
    ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");
    ModelAndView mvErr=new ModelAndView("Errorhandling.jsp");
    int x=Integer.parseInt(otpfromUser);  
    System.out.println(manager+ "Second step");
    if(x==otpx)
    {
    	if(manager==true)
    		return mvAdmin;
    	else
    		return mvEmp;
    }
    else
    	return mvErr;
	
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
		    customerid=user.getEmailId();
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
@RequestMapping("/")
public ModelAndView home()
{
	ModelAndView mv=new ModelAndView("home.jsp");
	return mv;
}
@RequestMapping("/addUser")
public ModelAndView addUser(User alien)
{
	ModelAndView xa=new ModelAndView("alreadyRegistered.jsp");

	for (User user : repo.findAll()) {
		  if(alien.getEmailId().equals(user.getEmailId()))
			  return xa;
	    }
		if(alien.getPassword().equals(alien.getReEnteredPassword())){
		repo.save(alien);
		ModelAndView xb=new ModelAndView("login.jsp");
		return xb;}
		else {
		ModelAndView xc=new ModelAndView("Errorhandling");
	    return xc;
	    }
}


}


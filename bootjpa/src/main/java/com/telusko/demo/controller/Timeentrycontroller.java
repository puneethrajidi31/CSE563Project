package com.telusko.demo.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.Service.Emailservice;
import com.telusko.demo.dao.Database;
import com.telusko.demo.model.Recipientemail;
import com.telusko.demo.model.Timeentry;



@CrossOrigin
@RequestMapping("")
@RestController

public class Timeentrycontroller {

@Autowired	
private Database database;

@Autowired
private  Emailservice emailservice;

Long xy;

@RequestMapping("/starttimer")
public ModelAndView shiftentry(Timeentry timeentry)
{   	
	ModelAndView mvEmp=new ModelAndView("welcomeEmployee.jsp");	
	Date starttime = new Date();
	System.out.println("Step1");
	timeentry.setStartdate(starttime);
	Timeentry timeentry1=database.save(timeentry);
	xy=timeentry1.getId();
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
	mvRecords.addObject("records", p);
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


}


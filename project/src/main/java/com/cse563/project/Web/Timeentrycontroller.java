package com.cse563.project.Web;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cse563.project.Model.Timeentry;
import com.cse563.project.Repository.Database;



@RequestMapping("")
@RestController
@CrossOrigin
public class Timeentrycontroller {

	
private Database database;


@PostMapping("/starttimer")
public ResponseEntity<?> shiftentry(@RequestBody Timeentry timeentry)
{
	Date starttime = new Date();
	System.out.println("Step1");
	timeentry.setStartdate(starttime);
	Timeentry timeentry1=database.save(timeentry);
	return new ResponseEntity<Timeentry>(timeentry1,HttpStatus.CREATED);
}

@PostMapping("/endtimer")
public ResponseEntity<?> completeentry(@RequestBody Timeentry timeentry)
{
	
	Date endtime=new Date();
    timeentry.setEnddate(endtime);
    database.save(timeentry);
	return new ResponseEntity<String>("Entry recorded", HttpStatus.CREATED);
}
	
@GetMapping("/fetchrecords")
public List<Timeentry>displayentries()
{
	List<Timeentry>p=database.findAll();
	return p;
}

}

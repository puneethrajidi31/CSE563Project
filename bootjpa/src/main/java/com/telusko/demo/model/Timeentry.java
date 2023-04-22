package com.telusko.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Timeentry {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String projectname;
private String lifecyclestep;
private String effortcategory;
private String plan;
private Date startdate;
private Date enddate;
private String acceptance;


public Timeentry() {
	super();
}





public Timeentry(Long id, String projectname, String lifecyclestep, String effortcategory, String plan, Date startdate,
		Date enddate, String acceptance) {
	super();
	this.id = id;
	this.projectname = projectname;
	this.lifecyclestep = lifecyclestep;
	this.effortcategory = effortcategory;
	this.plan = plan;
	this.startdate = startdate;
	this.enddate = enddate;
	this.acceptance = acceptance;
}





public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getProjectname() {
	return projectname;
}


public void setProjectname(String projectname) {
	this.projectname = projectname;
}


public String getLifecyclestep() {
	return lifecyclestep;
}


public void setLifecyclestep(String lifecyclestep) {
	this.lifecyclestep = lifecyclestep;
}


public String getEffortcategory() {
	return effortcategory;
}


public void setEffortcategory(String effortcategory) {
	this.effortcategory = effortcategory;
}


public String getPlan() {
	return plan;
}


public void setPlan(String plan) {
	this.plan = plan;
}


public Date getStartdate() {
	return startdate;
}


public void setStartdate(Date startdate) {
	this.startdate = startdate;
}


public Date getEnddate() {
	return enddate;
}


public void setEnddate(Date enddate) {
	this.enddate = enddate;
}





public String isAcceptance() {
	return acceptance;
}


public void setAcceptance(String acceptance) {
	this.acceptance = acceptance;
}













}


package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipientemail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ids;
	private String recipientmail;
	public Recipientemail() {
		super();
	}
	public Recipientemail(Long ids, String recipientmail) {
		super();
		this.ids = ids;
		this.recipientmail = recipientmail;
	}
	public Long getIds() {
		return ids;
	}
	public void setIds(Long ids) {
		this.ids = ids;
	}
	public String getRecipientmail() {
		return recipientmail;
	}
	public void setRecipientmail(String recipientmail) {
		this.recipientmail = recipientmail;
	}
	
}

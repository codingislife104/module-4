package com.capgemini.custcomplaint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint {
	@Id
	private int complaintId;
	private int accountId;
	private String branchCode;
	private String emailId;
	private String category;
	private String description;
	private String priority;
	private String status;
	
	public Complaint() {
		
	}
	
	public Complaint(int complaintId, int accountId, String branchCode,
			String emailId, String category, String description,
			String priority, String status) {
		super();
		this.complaintId = complaintId;
		this.accountId = accountId;
		this.branchCode = branchCode;
		this.emailId = emailId;
		this.category = category;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}


	public Complaint(int accountId, String branchCode, String emailId,
			String category, String description) {
		super();
		this.accountId = accountId;
		this.branchCode = branchCode;
		this.emailId = emailId;
		this.category = category;
		this.description = description;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="complaintid")
	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	@Column(name="accountid")
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Column(name="branchcode")
	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name="emailid")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getCategory() {		//category
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public String getDescription() {		//description
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getPriority() {			//priority
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	
	public String getStatus() {			//status
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", accountId="
				+ accountId + ", branchCode=" + branchCode + ", emailId="
				+ emailId + ", category=" + category + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}	
}

package com.capgemini.custcomplaint.services;


import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;

public interface ComplaintService {
	public void raiseComplaint(Complaint complaint) throws ComplaintException;
	public Complaint checkComplaintStatus(int complaintId) throws ComplaintException;
}

package com.capgemini.custcomplaint.daos;


import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;

public interface ComplaintDao {
	public void raiseComplaint(Complaint complaint) throws ComplaintException;
	public Complaint checkComplaintStatus(int complaintId) throws ComplaintException;
	

}

package com.capgemini.custcomplaint.services;


import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.capgemini.custcomplaint.daos.ComplaintDao;
import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;

@Service("tataPowerServices")
@Scope("singleton")
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	private ComplaintDao dao;
	
	@Resource
	public void setDao(ComplaintDao dao) {
		this.dao = dao;
	}

	
	@Override
	public void raiseComplaint(Complaint complaint) throws ComplaintException {
		dao.raiseComplaint(complaint);
		
	}

	@Override
	public Complaint checkComplaintStatus(int complaintId)throws ComplaintException {
		return dao.checkComplaintStatus(complaintId);
	}

	
}

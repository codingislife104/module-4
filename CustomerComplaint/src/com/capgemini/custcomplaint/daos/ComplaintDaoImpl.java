package com.capgemini.custcomplaint.daos;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;

@Repository
public class ComplaintDaoImpl implements ComplaintDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void raiseComplaint(Complaint complaint) throws ComplaintException {
		if(complaint.getCategory().equals("Internet Banking"))
		{
			complaint.setPriority("High");
			complaint.setStatus("Open");
		}
		else
			if(complaint.getCategory().equals("General Banking"))
			{
				complaint.setPriority("Medium");
				complaint.setStatus("Open");
			}
			else
				if(complaint.getCategory().equals("Other"))
				{
					complaint.setPriority("Low");
					complaint.setStatus("Open");
				}
		entityManager.persist(complaint);
		//System.out.println(complaint);
	}

	@Override
	public Complaint checkComplaintStatus(int complaintId)throws ComplaintException {
		Complaint complaint=entityManager.find(Complaint.class, complaintId);
		return complaint;
	} 
	

}

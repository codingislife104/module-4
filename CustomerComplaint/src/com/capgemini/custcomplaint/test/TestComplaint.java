package com.capgemini.custcomplaint.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;
import com.capgemini.custcomplaint.services.ComplaintService;


public class TestComplaint {
	public static void main(String[] args) {
		
	ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("SpringContext.xml");
	ComplaintService service=ctx.getBean(ComplaintService.class);
	Complaint cmplt = new Complaint(6873843, "FCFC2", "pooja@gmail.com", "Other", "Debit Card is lost");
	//int accountId, String branchCode, String emailId,String category, String description
	try {
		service.raiseComplaint(cmplt);
		System.out.println(cmplt);
		Complaint complaint = service.checkComplaintStatus(3145);
		System.out.println(complaint);
	} catch (ComplaintException e) {
		System.out.println("Error : "+e.getMessage());
	}
	ctx.close();
	}
}

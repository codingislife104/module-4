package com.capgemini.custcomplaint.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.capgemini.custcomplaint.entities.Complaint;
import com.capgemini.custcomplaint.exception.ComplaintException;
import com.capgemini.custcomplaint.services.ComplaintService;



/*
 *  http://localhost:8082/CustomerComplaint_133419/getRaiseComplaintForm.do
 */
@Controller
public class ComplaintController {
	private ComplaintService service;

	@Resource
	public void setService(ComplaintService service) {
		this.service = service;
	}
	
	@RequestMapping("/getRaiseComplaintForm.do")
	public ModelAndView getRaiseComplaintForm() {
		Complaint complaint = new Complaint();
		ModelAndView mAndv = new ModelAndView("index");
		ArrayList<String> categoryList= new ArrayList<>();
		categoryList.add("Internet Banking");
		categoryList.add("General Banking");
		categoryList.add("Other");
		mAndv.addObject("maComplaint", complaint);
		mAndv.addObject("categoryList", categoryList);
		return mAndv;
	}

	@RequestMapping("/addComplaint.do")
	public ModelAndView addComplaint(@ModelAttribute("maComplaint") Complaint complaint) throws ComplaintException{		
			service.raiseComplaint(complaint);
			int complaintId=complaint.getComplaintId();
			ModelAndView mAndv=new ModelAndView("successRaiseComplaint");
			mAndv.addObject("complaintId", complaintId);
			return mAndv;	
			
	}
	
	@RequestMapping("/getCheckStatusForm.do")
	public ModelAndView getCheckStatusForm(){
		ModelAndView mAndv = new ModelAndView("getStatus");
		return mAndv;
	}
	
	@RequestMapping("/checkStatus.do")
	public ModelAndView checkStatus(@RequestParam("complaintId") int complaintId) throws ComplaintException{
		Complaint complaint = service.checkComplaintStatus(complaintId);
		ModelAndView mAndv=new ModelAndView("getStatus");
		mAndv.addObject("complaint", complaint);
		return mAndv;		
	}
}

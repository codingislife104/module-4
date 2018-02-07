/*The controller class which will redirect all the links through it. It will take help of dispatcher servlet and web.xml to
 * understand various mappings*/
package com.capgemini.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.sky.bean.Sky;
import com.capgemini.sky.service.ISkyService;


@Controller
public class SkyController {
@Autowired
private ISkyService skyService;

@RequestMapping("showHomePage")
public String  showHomePage()
{
	return("index");
}

public ISkyService getProductService() {
	return skyService;
}

public void setSkyService(ISkyService skyService) {
	this.skyService = skyService;
}

@RequestMapping(value="Menu",method=RequestMethod.GET)
public String getMenuPage()
{
	return "Menu";
}
@RequestMapping(value="ViewAllData",method=RequestMethod.GET)
public ModelAndView getViewAllData()
{
		List<Sky> sky= skyService.getAllData();
		
		return new ModelAndView("ViewAllData", "sky", sky);
 
}

@RequestMapping(value="CustReportBycustNum")
public String CustReportBycustNum(@RequestParam("customerNumber")String customerNumber, Model model){
	
	try 
	{
		Sky sky = skyService.getServiceDetail(customerNumber);
		model.addAttribute("c", sky);
		return "CustReportBycustNum";
	} 
	catch (Exception e) 
	{
		model.addAttribute("msg", e.getMessage());
		return "myError";
	}
}
}

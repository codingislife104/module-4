package com.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.schedule.bean.Schedule;
import com.schedule.exception.ScheduleException;
import com.schedule.service.IScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	public IScheduleService scheduleService;
	
	@RequestMapping("showHomePage")
	public ModelAndView showHome(@ModelAttribute("schedule") Schedule schedule){
ModelAndView model=new ModelAndView();
		
		
		try {
			List<Schedule> list=scheduleService.viewAll();
			
			model.setViewName("index");
			model.addObject("list",list);
		} catch (ScheduleException e) {
			model.setViewName("error");
			model.addObject("message",e.getMessage());
		}
		
		
		return model;
	}
	
	@RequestMapping("update")
	public ModelAndView up(@ModelAttribute("schedule") Schedule schedule){
		ModelAndView model=new ModelAndView();
		model.addObject("schedule",schedule);
		model.setViewName("updateSession");
		
		return model;
	}
	
	
	@RequestMapping("update1")
	public ModelAndView update(@ModelAttribute("schedule") Schedule schedule){
		ModelAndView model=new ModelAndView();
		try {
			System.out.println(schedule.getMode());
			boolean isUpdated=scheduleService.update(schedule);
			
			model.addObject("update",isUpdated);
			model.addObject("schedule",schedule);
			model.setViewName("updatesucc");
			
		} catch (ScheduleException e) {
			model.setViewName("error");
			model.addObject("message","Unable to update employee in controller");
		}
		
		return model;	
		
	}
	
	@RequestMapping("updatesucc")
	public String updatesucc(){
		return "updatesucc";
	}
}

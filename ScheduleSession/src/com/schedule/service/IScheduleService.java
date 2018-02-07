package com.schedule.service;

import java.util.List;

import com.schedule.bean.Schedule;
import com.schedule.exception.ScheduleException;

public interface IScheduleService {
	public List<Schedule> viewAll()throws ScheduleException;
	
	public boolean update(Schedule schedule)throws ScheduleException;
}

package com.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.bean.Schedule;
import com.schedule.dao.IScheduleDao;
import com.schedule.exception.ScheduleException;

@Service
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private IScheduleDao scheduleDao;
	
	@Override
	public List<Schedule> viewAll() throws ScheduleException {
		
		return scheduleDao.viewAll();
	}

	@Override
	public boolean update(Schedule schedule) throws ScheduleException {
		
		return scheduleDao.update(schedule);
	}

}

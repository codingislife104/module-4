package com.schedule.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.schedule.bean.Schedule;
import com.schedule.exception.ScheduleException;

@Repository
@Transactional
public class ScheduleDaoImpl implements IScheduleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Schedule> viewAll() throws ScheduleException {
		List<Schedule> list=null;
		try {
			TypedQuery<Schedule> qry = entityManager.createQuery("from Schedule",Schedule.class);
			list = qry.getResultList();
		} catch (Exception e) {
			throw new ScheduleException("unable to fetch data in dao layer!"+e.getMessage());
		}
		
		return list;
	}


	@Override
	public boolean update(Schedule schedule) throws ScheduleException {
boolean isUpdated=false;
		
		
		try {
		//	EmployeeBean emp=entityManager.find(EmployeeBean.class, bean.getEmployeeId());

			
				//emp.setEmployeeName("Shyam");
				System.out.println(schedule);
				entityManager.merge(schedule);
				System.out.println(schedule);
				isUpdated=true;
		} catch (Exception e) {
			throw new ScheduleException("Unable to update employee in dao layer"+e.getMessage());
		}
		
		return isUpdated;
	}

}

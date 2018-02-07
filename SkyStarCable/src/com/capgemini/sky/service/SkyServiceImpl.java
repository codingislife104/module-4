/*The implementation of the DAO interface to provide the implementation details*/
package com.capgemini.sky.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.sky.bean.Sky;
import com.capgemini.sky.dao.ISkyDAO;
@Service
@Transactional
public class SkyServiceImpl implements ISkyService {
	@Autowired
	private ISkyDAO skyDAO;

	@Override
	public List<Sky> getAllData() {
		
		return skyDAO.getAllData();
	}

	@Override
	public Sky getServiceDetail(String customerNumber) {
		
		return skyDAO.getServiceDetail(customerNumber);
	}


}

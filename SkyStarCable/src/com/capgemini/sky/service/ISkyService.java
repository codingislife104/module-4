/*The interface of service which will have to call the dao class for better modularity.
 * It consists of various definitions of the functions which are present in the module
 * */
package com.capgemini.sky.service;

import java.util.List;

import com.capgemini.sky.bean.Sky;

public interface ISkyService {
	public List<Sky> getAllData();
	public Sky getServiceDetail(String customerNumber);
	
}

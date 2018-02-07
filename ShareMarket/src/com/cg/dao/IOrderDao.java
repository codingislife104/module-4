package com.cg.dao;

import com.cg.bean.OrderBean;
import com.cg.exception.ShareException;



public interface IOrderDao {
	  	
	public int addOrder(OrderBean oBean) throws ShareException;
	
}

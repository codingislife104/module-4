/*The interface of DAO to define various methods*/
package com.capgemini.sky.dao;

import java.util.List;

import com.capgemini.sky.bean.Sky;

public interface ISkyDAO {
public List<Sky> getAllData();
public Sky getServiceDetail(String customerNumber);
}

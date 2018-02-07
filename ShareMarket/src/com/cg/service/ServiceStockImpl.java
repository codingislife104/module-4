package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.StockBean;
import com.cg.dao.IStockDao;
import com.cg.exception.ShareException;

@Service
public class ServiceStockImpl implements IServiceStock {

	@Autowired
	private IStockDao stockDao;
	
	@Override
	public List<StockBean> retrieveAllStocks() throws ShareException {
		
		return stockDao.retrieveAllStocks();
	}

	@Override
	public StockBean displayStock(String stockName) throws ShareException {
	
		return stockDao.displayStock(stockName);
	}

}

package com.capgemini.spring.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.web.dao.IProductDAO;
import com.capgemini.spring.web.entities.Product;
import com.capgemini.spring.web.exception.ProductException;


@Service("ProductService")
@Transactional
public class ProductServiceImpl implements IProductService {

	static int count;
	
	{
		count++;
		System.out.println("instance created count = " + count);
	}
	
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public int addProductDetails(Product product) throws ProductException {
	
		return productDAO.addProductDetails( product );
	}

	@Override
	public Product getProduct(int id) throws ProductException {
		
		return productDAO.getProduct( id );
	}

	@Override
	public void updateProduct(Product product) throws ProductException {
		
		productDAO.updateProduct( product );
	}

	@Override
	public Product removeProduct(Product product) throws ProductException {
		
		return productDAO.removeProduct(product);
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		return productDAO.getAllProducts();
	}

}

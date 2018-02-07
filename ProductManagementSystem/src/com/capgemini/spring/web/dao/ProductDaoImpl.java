package com.capgemini.spring.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.spring.web.entities.Product;
import com.capgemini.spring.web.exception.ProductException;

@Repository("ProductDAO")
public class ProductDAOImpl implements IProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public int addProductDetails(Product product) throws ProductException {
		
		//Id will be assigned to the product
		try 
		{
			entityManager.persist( product );
			entityManager.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ProductException("Could not save product details");
		}
		
		return product.getId();
	}

	@Override
	public Product getProduct(int id) throws ProductException {
		
		Product product = null;
		
		try 
		{
			product = entityManager.find(Product.class, id);
			
			if( product == null )
				throw new Exception();
		} 
		catch (Exception e) 
		{
			throw new ProductException("Could not find the product with id " + id);
		}
		
		
		
		return product;
	}

	@Override
	public void updateProduct(Product product) throws ProductException {
	
		try 
		{
			entityManager.merge( product );
			entityManager.flush();
		} 
		catch (Exception e) 
		{
			throw new ProductException("Something went wrong while updating the product details. Try again");
		}

	}

	@Override
	public Product removeProduct(Product product) throws ProductException {
		
		try 
		{
			entityManager.remove(product);
			entityManager.flush();
		} 
		catch (Exception e) 
		{
			throw new ProductException("Something went wrong while removing the product details. Try again");
		}
		
		return null;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> products = new ArrayList<Product>();
		
		try 
		{
			TypedQuery<Product> query = 
			entityManager.createNamedQuery("GetAllProducts", Product.class);
			
			products = query.getResultList();
		}  
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ProductException("Something went wrong while trying to fetch all product records");
		}
		
		if( products.isEmpty() )
			throw new ProductException("No product to display");
		
		return products;
	}
}



 





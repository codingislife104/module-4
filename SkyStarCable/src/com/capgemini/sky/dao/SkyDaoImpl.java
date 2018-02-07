/*The implementation of the interface of the dao which provides the implementation of the
 * methods which are present in the dao*/
package com.capgemini.sky.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.sky.bean.Sky;

@Repository
public class SkyDAOImpl implements ISkyDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Sky> getAllData() {
		List<Sky> sky= null;
		
			TypedQuery<Sky> tquery= entityManager.createNamedQuery("GetAllData", Sky.class);
			
			sky= tquery.getResultList();
			
			
				
		/*catch (Exception e)
		{
			throw new ProductException(e.getMessage());
			
		}
		*/
		
		return sky;
	}

	@Override
	public Sky getServiceDetail(String customerNumber) {
	
		return entityManager.find(Sky.class,customerNumber);
	}
	}



package br.spring.mvc.model.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.spring.mvc.model.entities.Product;

@Repository
@Transactional
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager aEntityManager;

	public void save(Product pProduto) {
		this.aEntityManager.persist(pProduto);
	}
	
	public List<Product> selectAll() {
		List<Product> resultSet = new ArrayList<Product>();
		
		String sql = "Select p From Product p";
		
		TypedQuery<Product> typedQuery = 
			this.aEntityManager.createQuery(sql, Product.class);
		
		resultSet = typedQuery.getResultList();
		
		return resultSet;
	}
	
	private EntityManager getEntityManager() {
		if (this.aEntityManager == null) {
			Persistence.createEntityManagerFactory(persistenceUnitName)
		}
	}

}
package br.spring.mvc.model.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
	
	public void deleteAll() {
		List<Product> resultSet = new ArrayList<Product>();
		
		String sql = "Select p From Product p";
		
		TypedQuery<Product> typedQuery = 
			this.aEntityManager.createQuery(sql, Product.class);
		
		resultSet = typedQuery.getResultList();
		
		for (Product product : resultSet) {
			this.aEntityManager.remove(product);
		}
	}
	
	public Product select(Product pProduct) {
		Product result = 
			this.aEntityManager.find(Product.class, pProduct.getPrimaryKey());
		
		if ( result != null ) {
			this.aEntityManager.remove(result);
		}
		
		return result;
	}
	
	public void delete(Product pProduct) {
		Product result = 
			this.aEntityManager.find(
				Product.class, 
				pProduct.getPrimaryKey());
		
		if ( result != null ) {
			this.aEntityManager.remove(result);
		}
	}
	
}
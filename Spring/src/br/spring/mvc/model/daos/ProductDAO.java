package br.spring.mvc.model.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.spring.mvc.model.entities.Product;

@Repository
@Transactional
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager aEntityManager;
	
	private Logger logger;
	
	public ProductDAO() {
		// Logging messages
		this.logger = LoggerFactory.getLogger("spring.mvc.model.daos.ProductDAO");
		this.logger.info("ProductDAO instancialized");
	}
	
	/**
	 * Insert's a new Product in the database
	 * 
	 * @param pProduto
	 */
	public void save(Product pProduto) {
		this.aEntityManager.persist(pProduto);
	}
	
	/**
	 * Select all Products existing in database
	 * 
	 * @return		A Product list
	 */
	public List<Product> selectAll() {
		// A general Select query using JPQL
		String sql = "Select p From Product p";
		
		// A TypedQuery is created to do a general Select at database
		TypedQuery<Product> typedQuery = 
			this.aEntityManager.createQuery(sql, Product.class);
		
		// The ResultSet is ready
		List<Product> resultSet = typedQuery.getResultList();
		
		
		return resultSet;
	}
	
	/**
	 * Delete all Products existing in database
	 */
	public void deleteAll() {
		// A List with all Product is selected at database
		List<Product> resultSet = selectAll();
		
		// For each Product existing in database, Delete them one by one
		for (Product product : resultSet) {
			this.aEntityManager.remove(product);
		}
	}
	
	/**
	 * Select a specific Products, if it exists in database
	 * 
	 * @return		A Product list
	 */
	public Product select(Product pProduct) {
		Product result = null;
		
		// Validate the Product parameter, before trying to use it, avoiding a NullPointerException
		if (
				pProduct 					!= null		&& 
				pProduct.hasAnyAttributeValid()
		) {
			// Executes an Primary Key selection in database
			result = 
				this.aEntityManager.find(
					Product.class, 
					pProduct.getPrimaryKey()
				);
			
			/* TODO Why this peace of code does an Delete?!
			 *
			if ( result != null ) {
				this.aEntityManager.remove(result);
			}
			*/
		}
		
		return result;
	}
	
	/**
	 * Delete a specific Products, if it exists in database
	 * 
	 * @param pProduct
	 */
	public void delete(Product pProduct) {
		// Selects a Product, if it exists in database
		Product result = 
			select(pProduct);
		
		// If the Product were found at database, Delete it.
		if ( result != null ) {
			this.aEntityManager.remove(result);
		}
	}
	
}
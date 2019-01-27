package br.spring.mvc.model.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.spring.mvc.model.entities.Product;

@Repository
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager aEntityManager;

	public void save(Product pProduto) {
		this.aEntityManager.persist(pProduto);
		
	}

}
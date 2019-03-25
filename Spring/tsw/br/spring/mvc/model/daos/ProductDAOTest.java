package br.spring.mvc.model.daos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.spring.mvc.configs.ConfigurationJPA;
import br.spring.mvc.model.entities.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ConfigurationJPA.class, ProductDAO.class})
public class ProductDAOTest {
	
	@Autowired
	private ProductDAO aDAO;
	
	public void initializeDAO() {
		this.aDAO = new ProductDAO();
	}
	
	@Test
	public void testSelectAll_EmptyResultSet() {
		// Act
		List<Product> resultSet = this.aDAO.selectAll();
		
		// Assert
		assertNotNull(resultSet);
		assertTrue(resultSet.isEmpty());
	}
	
	@Test
	public void testInsertOneProduct() {
		// Arrange
		Product produto = new Product();
		produto.setTitle("The Hitchhiker's Guide to the Galaxy");
		produto.setDescription("The answer to life, the universe and everything");
		produto.setPages(42);
		
		// Act
		this.aDAO.save(produto);
		
		// Assert
		// If it do not throw an Exception, its fine for now
	}
	
}
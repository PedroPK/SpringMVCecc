		package br.spring.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.spring.mvc.model.daos.ProductDAO;
import br.spring.mvc.model.entities.Product;

@Controller
@Transactional
public class ProductController {
	
	private Logger logger;
	
	@Autowired
	private ProductDAO aDAO;
	
	public ProductController() {
		// Logging messages
		this.logger = LoggerFactory.getLogger("spring.mvc.controllers.ProductController");
		this.logger.info("ProductController instancialized");
	}
	
	@RequestMapping("/registerProduct")
	public ModelAndView submit(Product pProduto) {
		// Logging messages
		logger.debug("ProductController - /registerProduct");
		
		// This constructor defines to where the Request should be redirected
		ModelAndView mv = new ModelAndView("cadastroProdutos");
		if (
				pProduto	!= null		&&
				pProduto.hasAnyAttributeValid()
		) {
			// Logging messages
			logger.debug(pProduto.toString());
			
			// Insert the Product
			this.aDAO.save(pProduto);
			
			// Select the inserted Product
			Product insertedProduct = this.aDAO.select(pProduto);
			
			// Mount a List of Products, that may be listed at JSP any moment in the future
			List<Product> listInsertedProducts = new ArrayList<Product>();
			listInsertedProducts.add(insertedProduct);
			
			// This method adds an object that has to be available in JSP
			mv.addObject("product",					insertedProduct);
			mv.addObject("listInsertedProducts",	listInsertedProducts);
			
			mv = new ModelAndView("productList");
		} else {
			// Logging messages
			logger.debug("Produto Nulo!");
		}
		
		return mv;
	}
	
	@RequestMapping("/Spring/products")
	public String submit2() {
		logger.debug("ProductController - /Spring/products");
		return "cadastroProdutos";
	}
	
	@RequestMapping("/products")
	public String showForms() {
		logger.debug("ProductController - /Spring/products");
		return "cadastroProdutos";
	}
	
	@RequestMapping("/products/form")
	public String form() {
		logger.debug("ProductController - /products/form");
		return "products/form";
	}
	
	@RequestMapping("/")
	public String index() {
		logger.debug("Página Inicial");
		return "index.jsp";
	}
	
	public String save(Product pProduto) {
		aDAO.save(pProduto);
		
		return "products/save/ok";
	}
}
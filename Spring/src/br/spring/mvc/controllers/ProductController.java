		package br.spring.mvc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			List<Product> listInsertedProducts = this.aDAO.selectAll();
			
			// This method adds an object that has to be available in JSP
			mv.addObject("product",			insertedProduct);
			mv.addObject("listProducts",	listInsertedProducts);
			
			//mv = new ModelAndView("cadastroProdutos");
		} else {
			// Logging messages
			logger.debug("Produto Nulo!");
		}
		
		return mv;
	}
	
	@RequestMapping("/registerProductRedirection")
	public String submitRedirection(
		Product				pProduto,
		RedirectAttributes	pRedirectAttributes
	) {
		// Logging messages
		logger.debug("ProductController - /registerProductRedirection");
		
		// This constructor defines to where the Request should be redirected
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
			List<Product> listInsertedProducts = this.aDAO.selectAll();
			
			// This method adds an object that has to be available in JSP
			pRedirectAttributes.addFlashAttribute("product",		insertedProduct);
			pRedirectAttributes.addFlashAttribute("listProducts",	listInsertedProducts);
		} else {
			// Logging messages
			logger.debug("Produto Nulo!");
		}
		
		return "redirect:cadastroProdutos";
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
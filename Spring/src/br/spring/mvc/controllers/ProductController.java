		package br.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.spring.mvc.model.daos.ProductDAO;
import br.spring.mvc.model.entities.Product;

@Controller
@Transactional
public class ProductController {
	
	@Autowired
	private ProductDAO aDAO;
	
	@RequestMapping("/registerProduct")
	public String submit(Product pProduto) {
		System.out.println("ProductController - /registerProduct");
		if ( pProduto != null ) {
			System.out.println(pProduto.toString());
			
			this.aDAO.save(pProduto);
		} else {
			System.out.println("Produto Nulo!");
		}
		
		return "products/form";
	}
	
	@RequestMapping("/Spring/products")
	public String submit2() {
		System.out.println("ProductController - /Spring/products");
		return "cadastroProdutos";
	}
	
	@RequestMapping("/products")
	public String showForms() {
		System.out.println("ProductController - /Spring/products");
		return "cadastroProdutos";
	}
	
	@RequestMapping("/products/form")
	public String form() {
		System.out.println("ProductController - /products/form");
		return "products/form";
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("Página Inicial");
		return "index.jsp";
	}
	
	public String save(Product pProduto) {
		aDAO.save(pProduto);
		
		return "products/save/ok";
	}
}
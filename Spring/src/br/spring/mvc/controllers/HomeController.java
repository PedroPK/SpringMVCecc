package br.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	/**
	 * URL to access this Controller:
	 *  - http://localhost:8080/Spring/home
	 * 
	 * @author pedropk
	 *
	 */
	@RequestMapping("/home")
	public String index() {
		System.out.println("index() do HomeController executado.");
		
		return "index";
	}
	
	/**
	 * URL to access this Controller:
	 *  - http://localhost:8080/Spring/cadastroProdutos
	 * 
	 * @author pedropk
	 *
	 */
	@RequestMapping("/cadastroProdutos")
	public String cadastro() {
		System.out.println("cadastro() do HomeController executado.");
		
		return "cadastroProdutos";
	}
	
}
package br.spring.mvc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.spring.mvc.controllers.HomeController;
import br.spring.mvc.model.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(
	basePackageClasses= {
		HomeController.class,
		ProductDAO.class
	}
)
public class SpringAppWebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}
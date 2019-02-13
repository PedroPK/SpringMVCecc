package br.spring.mvc.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfigSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			SpringAppWebConfig.class,
			ConfigurationJPA.class
		};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}

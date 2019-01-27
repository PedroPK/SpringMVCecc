package br.spring.mvc.configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class ConfigurationJPA {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(getDataSource());
		em.setPackagesToScan(
			new String[] {
				"br.spring.mvc.model.entities"
			}
		);
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		
		em.setJpaVendorAdapter(		jpaVendorAdapter);
		em.setJpaProperties(		getAdditionalProperties());
		
		return em;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(	"org.h2.Driver");
		dataSource.setUrl(				"jdbc:h2:mem:springMVCdataBase");
		dataSource.setUsername(			"springMvcDatabaseUser");
		dataSource.setPassword(			"");
		
		return dataSource;
	}
	
	public Properties getAdditionalProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.hbm2ddl.autohibernate.hbm2ddl.auto",		"update");
		properties.setProperty("hibernate.dialect",									"org.hibernate.dialect.H2Dialect");
		properties.setProperty("show_sql",											"true");
		
		return properties;
	}
	
}
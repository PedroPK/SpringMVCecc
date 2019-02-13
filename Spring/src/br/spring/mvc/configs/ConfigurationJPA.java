package br.spring.mvc.configs;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ConfigurationJPA {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan(
			//new String[] {
				"br.spring.mvc.model.entities"
			//}
		);
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		
		emf.setJpaVendorAdapter(	jpaVendorAdapter);
		emf.setJpaProperties(		getAdditionalProperties());
		
		return emf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(	"org.h2.Driver");
		
		/*
		 * To avoid the problem of Table Not Found on SQL Statement
		 * 
		 * javax.persistence.PersistenceException 
		 * org.hibernate.exception.SQLGrammarException 
		 * org.h2.jdbc.JdbcSQLException 
		 * 
		 * https://stackoverflow.com/questions/5763747/h2-in-memory-database-table-not-found
		 */
		dataSource.setUrl(				"jdbc:h2:mem:springMVCdataBase;DB_CLOSE_DELAY=-1");
		
		dataSource.setUsername(			"root");
		dataSource.setPassword(			"");
		
		return dataSource;
	}
	
	/**
	 * MWA - persistence.xml
	 * 
	 * <property name="javax.persistence.jdbc.driver"					value="org.h2.Driver" />
	 * <property name="javax.persistence.jdbc.url"						value="jdbc:h2:mem:testBase" />
	 * <property name="javax.persistence.jdbc.user"						value="sa" />
	 * <property name="javax.persistence.jdbc.password"					value="" />
	 * 
	 * <property name="hibernate.dialect"								value="org.hibernate.dialect.H2Dialect"/>
	 * <property name="hibernate.hbm2ddl.auto"							value="create-drop" />
	 * <property name="hibernate.temp.use_jdbc_metadata_defaults"		value="false"/>
	 * <property name="show_sql"										value="true"/>
	 * 
	 * @return
	 */
	public Properties getAdditionalProperties() {
		Properties properties = new Properties();
		
		//properties.setProperty("hibernate.hbm2ddl.autohibernate.hbm2ddl.auto",		"create");
		properties.setProperty("hibernate.hbm2ddl.auto",							"create");
		properties.setProperty("hibernate.dialect",									"org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.show_sql",								"true");
		
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager( EntityManagerFactory pEMF ) {
		JpaTransactionManager jpaTM = new JpaTransactionManager();
		jpaTM.setEntityManagerFactory(pEMF);
		
		return jpaTM;
	}
	
}
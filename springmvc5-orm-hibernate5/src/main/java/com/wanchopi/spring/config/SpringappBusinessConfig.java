package com.wanchopi.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Wanchopii
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.wanchopi.spring.*" })
@PropertySource( "classpath:database.properties" )
@EnableTransactionManagement
public class SpringappBusinessConfig {
	
	@Autowired
	private Environment env;

	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {
            "com.wanchopi.spring.entity"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("mysql.driver"));
		dataSource.setUrl(env.getProperty("mysql.url"));
		dataSource.setUsername(env.getProperty("mysql.username"));
		dataSource.setPassword(env.getProperty("mysql.password"));
		return dataSource;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        // Setting Hibernate properties
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        // Setting C3P0 properties
        properties.put("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
        properties.put("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
        properties.put("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
        properties.put("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
        return properties;
    }
	
	@Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}





















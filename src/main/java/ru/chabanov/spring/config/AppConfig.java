package ru.chabanov.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.chabanov.spring.dao.CRUD;
import ru.chabanov.spring.dao.CRUDImpl;

import javax.sql.DataSource;
import java.util.Properties;


@EnableTransactionManagement
@ComponentScan("ru.chabanov.spring")
@PropertySource("classpath:db-config.properties")
public class AppConfig {
    @Bean
    public DataSource dataSource(
            @Value("${datasource.driver}") final String dataSourceDriver,
            @Value("${datasource.url}") final String dataSourceUrl,
            @Value("${datasource.user}") final String dataSourceUserName,
            @Value("${datasource.password}") final String dataSourcePassword

    ){
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceDriver);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUserName);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (
            final DataSource dataSource,
            @Value("${hibernate.show_sql}") final String show_sql,
            @Value("${hibernate.dialect}") final String dialect,
            @Value("${hibernate.hbm2ddl.auto}") final String hbm2ddl
            )
    {
        final LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("ru.chabanov.spring.model");
        final Properties properties = new Properties();
        properties.put("hibernate.show_sql",show_sql);
        properties.put("hibernate.dialect",dialect);  // InnoDB работает без косяков fk создает
        properties.put("hibernate.hbm2ddl.auto",hbm2ddl);
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }
    @Bean
    public PlatformTransactionManager transactionManager(
            final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return transactionManager;
    }


}

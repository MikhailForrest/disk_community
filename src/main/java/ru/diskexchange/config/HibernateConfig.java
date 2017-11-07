package ru.diskexchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost/testdb");
        dataSource.setUsername("SA");
        dataSource.setPassword("");
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean EnMaFa = new LocalContainerEntityManagerFactoryBean();
        EnMaFa.setDataSource(this.dataSource());
        EnMaFa.setPackagesToScan(new String[] { "ru.diskexchange.domain" });

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        EnMaFa.setJpaVendorAdapter(va);
        EnMaFa.setJpaProperties(this.hibernateProperties());
        EnMaFa.afterPropertiesSet();
        return EnMaFa;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager TrMa = new JpaTransactionManager();
        TrMa.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return TrMa;
    }
    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        return properties;
    }
}




package ru.diskcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.diskcommunity.config.HibernateConfig;


@Configuration
@Import(HibernateConfig.class)
@ComponentScan({"ru.diskcommunity.service", "ru.diskcommunity.web"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"ru.diskcommunity.repositories"})
public class MySpringApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MySpringApplication.class, args);
    }
}
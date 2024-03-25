package org.ppf.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.ppf")
@EnableJpaRepositories(basePackages = {"org.ppf.model.dao"})
@EntityScan("org.ppf.model.entity")
public class TransactionsRun {

    public static void main(String[] args) {
        SpringApplication.run(TransactionsRun.class, args);
    }
}

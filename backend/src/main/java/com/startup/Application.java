package com.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <h1>Primary Startup Application</h1>
 * <p>This class will contain only the main method, responsible for starting the spring boot application</p>
 *
 * @author Alexander Montgomery
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.controllers", "com.repository"})
@EnableJpaRepositories("com.repository")
@EntityScan("com.domain")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

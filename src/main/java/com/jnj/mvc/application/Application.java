package com.jnj.mvc.application;
  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
  
@SpringBootApplication
@EntityScan(basePackages = { "com.jnj.mvc.entity" })
@EnableJpaRepositories(basePackages = { "com.jnj.mvc.repository" })
@ComponentScan(basePackages = {"com.jnj.mvc.controller"})
public class Application {
      public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
      }
}
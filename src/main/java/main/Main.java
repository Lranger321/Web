package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"main.*"})
@EntityScan("main.*")
@EnableJpaRepositories("main.*")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

package com.boarddio;

import com.boarddio.menu.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardDioApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BoardDioApplication.class, args);
        Menu menu = context.getBean(Menu.class);
        menu.exibirMenu();
    }

    @Bean
    CommandLineRunner runner(Menu menu) {
        return args -> menu.exibirMenu();
    }
}

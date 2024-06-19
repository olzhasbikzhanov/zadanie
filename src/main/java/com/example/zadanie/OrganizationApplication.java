package com.example.zadanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс, являющийся основной точкой входа для запуска приложения, основанного на Spring Boot.
 * Запускает Spring Boot приложение с автоматической конфигурацией.
 */
@SpringBootApplication
public class OrganizationApplication {

    /**
     * Метод main, запускающий приложение.
     */
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }
}
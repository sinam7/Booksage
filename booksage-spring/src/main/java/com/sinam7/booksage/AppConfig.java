package com.sinam7.booksage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient KyoboApiProductClient() {
        return WebClient.create("https://product.kyobobook.co.kr");
    }

    @Bean
    public WebClient LibraryApiProductClient() {
        return WebClient.create("https://lib.kookmin.ac.kr");
    }

    @Bean
    public WebDriver webDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

//    @Bean
//    public WebClient KyoboApiSearchClient() {
//        return WebClient.create("https://search.kyobobook.co.kr");
//    }

//    @Bean
//    public WebClient InterparkApiClient() {
//        return WebClient.create("https://book.interpark.com");
//    }
}

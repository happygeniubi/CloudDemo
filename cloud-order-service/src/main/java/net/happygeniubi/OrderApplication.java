package net.happygeniubi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("net.happygeniubi.dao")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class);

    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
package net.happygeniubi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("net.happygeniubi.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class VideoApplication {

    public static void main(String[] args) {

        SpringApplication.run(VideoApplication.class, args);

    }
}


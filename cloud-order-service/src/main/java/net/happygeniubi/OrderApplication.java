package net.happygeniubi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("net.happygeniubi.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class);

    }

    @Bean
    // 分析@LoadBalanced
    // 1）首先从注册中心获取provider的列表
    // 2）通过一定的策略选择其中一个节点
    // 3）再返回给restTemplate调用
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

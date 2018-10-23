package cn.vpclub.sinotrans.sailor.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 启动类
 *
 * @author chentao
 */
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SailorWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SailorWebApplication.class, args);
    }
}


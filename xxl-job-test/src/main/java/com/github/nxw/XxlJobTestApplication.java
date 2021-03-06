package com.github.nxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auth：niuxiaowen
 * @Desc:
 * @Date: 2021/5/25
 */
@EnableEurekaClient
@EnableFeignClients({"com.github.nxw"})
@SpringBootApplication
public class XxlJobTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(XxlJobTestApplication.class);
    }
}

package com.lyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com/lyj/springcloud/dao") //扫描mybatis注解
@SpringBootApplication
@EnableEurekaClient	//标注是eureka客户端，表示本服务启动后会自动注册进eureka服务中
@ComponentScan("com.lyj.springcloud")   //指定要扫描的包
public class DeptProvider8001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}

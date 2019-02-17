package com.lyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@MapperScan("com/lyj/springcloud/dao") //扫描mybatis注解
@SpringBootApplication
@EnableEurekaClient	//标注是eureka客户端，表示本服务启动后会自动注册进eureka服务中
@EnableHystrix	//开启熔断服务
public class DeptProvider_Hystrix_8001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider_Hystrix_8001_App.class, args);
	}
}

package com.lyj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	//标注是eureka服务端，接受其它微服务注册进来
public class EurekaServer7001_App {
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServer7001_App.class, args);
	}
}

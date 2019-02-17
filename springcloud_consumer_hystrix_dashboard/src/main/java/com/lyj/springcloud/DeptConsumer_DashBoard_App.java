package com.lyj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控系统：
 * 	监控微服务的系统况状，以图标的形式展示
 */
@SpringBootApplication
@EnableHystrixDashboard	//开启服务监控
public class DeptConsumer_DashBoard_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}
}

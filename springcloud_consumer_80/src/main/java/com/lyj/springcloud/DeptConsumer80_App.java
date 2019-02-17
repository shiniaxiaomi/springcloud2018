package com.lyj.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

    //添加RestTemplate的bean
    @Bean
    @LoadBalanced   //添加客户端的负载均衡注解（默认使用轮询算法）
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    //如果替换默认的，则使用轮询算法
    @Bean
    public IRule iRule(){
        return new RoundRobinRule();//使用轮询算法
//        return new RandomRule();//使用随机算法
    }

}

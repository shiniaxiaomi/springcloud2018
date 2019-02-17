package com.lyj.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.lyj.springcloud"})  //指定feign接口所在的包
@ComponentScan("com.lyj.springcloud")   //指定要扫描的包
public class DeptConsumer_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign_App.class, args);
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

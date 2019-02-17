package com.lyj.springcloud.service;

import com.lyj.springcloud.entities.Dept;
import com.lyj.springcloud.fallBack.DeptFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2019/2/15.
 */

/**
 * 注解+接口 即可生效
 */
@Component
//@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")   //指定微服务的名字即可
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptFallBackFactory.class)//指定服务异常时处理的类
public interface DeptService {

    @RequestMapping(value = "/dept/add")
    public boolean add(Dept dept);

    @RequestMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/dept/list")
    public List<Dept> list();
}

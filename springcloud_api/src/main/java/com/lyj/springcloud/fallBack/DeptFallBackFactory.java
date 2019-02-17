package com.lyj.springcloud.fallBack;

import com.lyj.springcloud.entities.Dept;
import com.lyj.springcloud.service.DeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/2/16.
 */

@Component  //一定要添加
public class DeptFallBackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,微服务已经降级处理，请稍后再试!")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}

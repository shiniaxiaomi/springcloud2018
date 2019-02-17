package com.lyj.springcloud.controller;

import com.lyj.springcloud.entities.Dept;
import com.lyj.springcloud.service.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController
{
	@Autowired
	private DeptServiceImpl deptService;

	@RequestMapping(value = "/dept/get/{id}")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if(dept==null){
			throw new RuntimeException("没有对应的部门");
		}
		return dept;
	}

	//当出现方法调用错误之后，由这个方法进行后续的处理和返回结果
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

}

package com.lyj.springcloud.controller;

import com.lyj.springcloud.entities.Dept;
import com.lyj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

	@Autowired
	DeptService deptService;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}

}

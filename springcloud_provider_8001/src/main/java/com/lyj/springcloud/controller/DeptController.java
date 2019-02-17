package com.lyj.springcloud.controller;

import com.lyj.springcloud.entities.Dept;
import com.lyj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeptController
{

	@Autowired
	DeptService deptService;

	@RequestMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}


}

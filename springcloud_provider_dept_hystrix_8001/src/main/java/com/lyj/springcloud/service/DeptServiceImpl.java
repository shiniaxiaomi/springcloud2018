package com.lyj.springcloud.service;

import com.lyj.springcloud.dao.DeptDao;
import com.lyj.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	public boolean add(Dept dept)
	{
		return deptDao.addDept(dept);
	}

	public Dept get(Long id)
	{
		return deptDao.findById(id);
	}

	public List<Dept> list()
	{
		return deptDao.findAll();
	}

}

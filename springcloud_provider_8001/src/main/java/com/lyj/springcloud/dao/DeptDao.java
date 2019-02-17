package com.lyj.springcloud.dao;

import com.lyj.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/2/14.
 */
@Repository
public interface DeptDao {

    @Insert("INSERT INTO dept(dname,db_source) VALUES(#{dname},DATABASE())")
    public boolean addDept(Dept dept);

    @Select("select deptno,dname,db_source from dept where deptno=#{deptno}")
    public Dept findById(Long id);

    @Select("select deptno,dname,db_source from dept")
    public List<Dept> findAll();
}

package com.nxs.service;

import com.nxs.model.Pager;
import com.nxs.model.Student;

/**
 * Created by jonenxs on 2017/3/2.
 */
public interface StudentService {
    /**
     * 根据查询条件，查询学生分页信息
     * @param searchModel 封装查询条件
     * @param pageNum 查询第几页数据
     * @param pageSize 每页显示多少条数据
     * @return 查询结果
     */
    public Pager<Student> findStudents(Student searchModel,int pageNum,int pageSize);
}

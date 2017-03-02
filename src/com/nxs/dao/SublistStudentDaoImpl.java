package com.nxs.dao;

import com.nxs.Constant;
import com.nxs.model.Pager;
import com.nxs.model.Student;
import com.nxs.util.JdbcUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonenxs on 2017/3/2.
 */
public class SublistStudentDaoImpl implements StudentDao {

    @Override
    public Pager<Student> findStudents(Student searchModel, int pageNum, int pageSize) {
        List<Student> studentList = getAllStudent(searchModel);

        return null;
    }

    /**
     * 模仿获取所有数据
     * @param searchModel 查询数据
     * @return 查询数据
     */
    private List<Student> getAllStudent(Student searchModel){
        List<Student> result = new ArrayList<Student>();
        List<Object> paramList = new ArrayList<>();

        String stuName = searchModel.getStuName();
        int gender = searchModel.getGender();

        StringBuilder sql = new StringBuilder("select * from t_student where 1 = 1");
        if (stuName != null && !stuName.equals("")){
            sql.append("and stu_name like ?");
            paramList.add("%" + stuName + "%");
        }

        if (gender == Constant.GENDER_MALE && gender == Constant.GENDER_FMALE ){
            sql.append("and gender = ?");
            paramList.add(gender);
        }
        JdbcUtil jdbcUtil = null;
        try {
            jdbcUtil = new JdbcUtil();
            jdbcUtil.getConnection();//获取数据库链接
            List<Map<String,Object>> mapList =  jdbcUtil.findResult(sql.toString(),paramList);
            if (mapList != null){
                for (Map<String,Object> map : mapList){
                    Student student = new Student(map);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常！",e);
        } finally {
            if (jdbcUtil != null){
                jdbcUtil.releaseConn();
            }
        }
        return result;
    }
}

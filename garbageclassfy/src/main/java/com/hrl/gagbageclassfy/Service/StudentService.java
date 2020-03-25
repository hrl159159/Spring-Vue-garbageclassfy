package com.hrl.gagbageclassfy.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.Student;

public interface StudentService {
    /**
     * 分页查询所有学生信息
     * @return
     */

    IPage<Student> findAll(Page<Student> studentPage);

    /**
     * 通过Id查询一个学生记录
     * @param studentId
     * @return
     */

    Student findById(Integer studentId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */

    int updateById(Student student);

    /**
     * 修改密码
     * @param student
     * @return
     */
    int updatePwd(Student student);

    /**
     * 通过学生Id删除一条学生记录
     * @param studentId
     * @return
     */
    int deleteById(Integer studentId);

    /**
     * 添加一个学生记录
     * @param student
     * @return
     */

    int add(Student student);
}

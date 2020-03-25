package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.Admin;
import com.hrl.gagbageclassfy.Entity.Student;

import com.hrl.gagbageclassfy.Entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDAO {

    /**
     * 验证是否是管理员登录
     */
    @Select("SELECT adminid,sex,tel,email,cardid,role FROM ADMIN WHERE adminid=#{username} and pwd=#{password}")
     Admin adminlogin(Integer username,String password);

    /**
     * 验证是否是学生登录
     */
    @Select("SELECT * FROM STUDENT where studentId = #{username} and pwd = #{password}")
     Student studentlogin(Integer username,String password);

    /**
     * 验证是否是教师登录
     * @param username
     * @param password
     * @return
     */
    @Select("select * from teacher where teacherId = #{username} and pwd = #{password}")
    Teacher teacherlogin(Integer username, String password);
}

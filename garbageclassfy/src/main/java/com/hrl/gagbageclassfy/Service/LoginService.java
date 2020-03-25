package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.Admin;
import com.hrl.gagbageclassfy.Entity.Student;
import com.hrl.gagbageclassfy.Entity.Teacher;
import org.springframework.stereotype.Service;


public interface LoginService {
    /**
     * 管理员登录，将前端数据与数据匹配，
     * 匹配的话返回一个admin对象
     */
    Admin adminlogin(Integer username,String password);


    /**
     * 学生登录，将前端数据与数据匹配，
     * 匹配的话返回一个admin对象
     */
    Student studentlogin(Integer username,String password);

    /**
     * 教师登录，将前端数据与数据匹配，
     * 匹配的话返回一个admin对象
     */
    Teacher teacherlogin(Integer username, String password);
}

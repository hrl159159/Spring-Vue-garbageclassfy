package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.LoginDAO;
import com.hrl.gagbageclassfy.Entity.Admin;
import com.hrl.gagbageclassfy.Entity.Student;
import com.hrl.gagbageclassfy.Entity.Teacher;
import com.hrl.gagbageclassfy.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;

    /**
     * 管理员登录，将前端数据与数据匹配，
     * 匹配的话返回一个admin对象
     */
    @Override
    public Admin adminlogin(Integer username, String password) {
        return loginDAO.adminlogin(username,password);
    }


    /**
     * 学生登录，将前端数据与数据匹配，
     * 匹配的话返回一个admin对象
     */
    @Override
    public Student studentlogin(Integer username, String password) {
        return loginDAO.studentlogin(username,password);
    }

    @Override
    public Teacher teacherlogin(Integer username, String password) {
        return loginDAO.teacherlogin(username, password);
    }
}

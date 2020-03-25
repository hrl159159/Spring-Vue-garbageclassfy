package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.TeacherDAO;
import com.hrl.gagbageclassfy.Entity.Teacher;
import com.hrl.gagbageclassfy.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;
    @Override
    public Teacher findByIdAndPwd(Integer username, String password) {
        return teacherDAO.findByIdAndPwd(username, password);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public int deleteById(Integer teacherId) {
        return teacherDAO.deleteById(teacherId);
    }

    @Override
    public int updateById(Teacher teacher) {
        return teacherDAO.updateById(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherDAO.add(teacher);
    }
}

package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher findByIdAndPwd(Integer username, String password);


    List<Teacher> findAll();


    int deleteById(Integer teacherId);


    int updateById(Teacher teacher);


    int add(Teacher teacher);
}

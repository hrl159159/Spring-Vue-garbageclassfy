package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.DAO.StudentDAO;
import com.hrl.gagbageclassfy.Entity.Student;
import com.hrl.gagbageclassfy.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
//    @Cacheable("student")
    public IPage<Student> findAll(Page<Student> studentPage) {

        return studentDAO.findAll(studentPage);
    }

//    @Override
//    public Student findById(Integer studentId) {
//        ValueOperations<Integer,Student> valueOperations=redisTemplate.opsForValue();
//
//        //判断缓存里是否有Key
//        boolean haskey=redisTemplate.hasKey(studentId);
//        //缓存里面有数据时，从缓存里获取数据
//        if(haskey){
//            System.out.println("=============从缓存获取数据===============");
//            Student student=valueOperations.get(studentId);
//            System.out.println(student.getStudentName());
//            System.out.println("=======================================");
//            return student;
//        }
//        //当缓存里没有数据时，从数据库里获取，获取后并让缓存储存
//        else {
//            System.out.println("=============从数据库获取数据===============");
//            Student student= studentDAO.findById(studentId);
//            System.out.println("=======================================");
//
//            //将数据写入缓存
//            valueOperations.set(studentId,student,5, TimeUnit.HOURS);
//            return student;
//        }
//    }
    @Override
    @Cacheable(value = "student")
    public Student findById(Integer studentId) {
        return studentDAO.findById(studentId);
    }

//
    //@cacheput用于更新操作，不管缓存有没有对应的数据，都是从数据库拿到数据，并将更新结果更新到缓存，并返回结果
    @Override
    @CachePut(value = "student")
    public int updateById(Student student){
        return studentDAO.updateById(student);
    }

    @Override
    @CachePut(value = "student")
    public int updatePwd(Student student) {

        return studentDAO.updatePwd(student);
    }

    //清除缓存
    @Override
    @CacheEvict(value = "student")
    public int deleteById(Integer studentId) {
        return studentDAO.deleteById(studentId);
    }

    @Override
    @Cacheable(value = "student")
    public int add(Student student) {
        return studentDAO.add(student);
    }
}

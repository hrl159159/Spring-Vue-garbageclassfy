package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    /**
     * 测试字符串缓存
     */
    @RequestMapping("/redisstring")
    public String StringTest(){
        stringRedisTemplate.opsForValue().set("stringtest","i am string test");
        String result=stringRedisTemplate.opsForValue().get("stringtest");
        System.out.println("缓存结果：result:"+result);
        return result;
    }

//    /**
//     * 测试hash缓存
//     * @return
//     */
//    @RequestMapping("/redishash")
//    public Map<String,Object> HashTest(){
//        Student student=new Student();
//        student.setStudentName("侯荣亮");
//        student.setPwd("123456");
//
//        redisTemplate.opsForHash().put("hrl","name",student.getStudentName());
//        redisTemplate.opsForHash().put("hrl","pwd",student.getPwd());
//
//    }


}

package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.*;
import com.hrl.gagbageclassfy.Service.ServiceImpl.LoginServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login){
        Integer username=login.getUsername();
        String password=login.getPassword();
        Admin admin=loginService.adminlogin(username,password);

        if(admin!=null){
            return ApiResultHandler.buildApiResult(200,"",admin);
        }


        Teacher teacher=loginService.teacherlogin(username,password);
        if(teacher!=null){
            return ApiResultHandler.buildApiResult(200,"",teacher);
        }

        Student student=loginService.studentlogin(username,password);
        if(student!=null){
            return ApiResultHandler.buildApiResult(200,"",student);
        }
        return ApiResultHandler.buildApiResult(200,"",null);
    }
}

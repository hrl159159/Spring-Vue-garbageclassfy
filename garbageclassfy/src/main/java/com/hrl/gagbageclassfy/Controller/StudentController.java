package com.hrl.gagbageclassfy.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.Student;
import com.hrl.gagbageclassfy.Service.ServiceImpl.StudentServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    /**
     * 分页查询所有学生
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/students/{page}/{size}")
    public ApiResult findAll(@PathVariable("page")Integer page,@PathVariable("size") Integer size){
        Page<Student> studentPage=new Page<>(page,size);
        IPage<Student> studentIPage=studentService.findAll(studentPage);
        return ApiResultHandler.buildApiResult(200,"请求成功",studentIPage);
    }

    /**
     * 根据Id查找学生信息
     * @param studentId
     * @return
     */
    @GetMapping("/student/{studentId}")
    public ApiResult findById(@PathVariable("studentId")Integer studentId){
        Student res=studentService.findById(studentId);
        if(res!=null){
            return ApiResultHandler.buildApiResult(200,"查找成功",res);
        }
            else {
                return ApiResultHandler.buildApiResult(400,"查找失败",res);
        }
    }

    /**
     * 根据Id删除学生信息
     * @param studentId
     * @return
     */
    @DeleteMapping("/student/{studentId}")
    public ApiResult deleteById(@PathVariable("studentId")Integer studentId){
        int res=studentService.deleteById(studentId);
        if(res!=0){
            return ApiResultHandler.buildApiResult(200,"删除成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"删除失败",res);
        }
    }

    /**
     * 根据Id更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/student")
    public ApiResult updateById(@RequestBody Student student){
        int res=studentService.updateById(student);
        if(res!=0){
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"更新失败",res);
        }
    }


    @PutMapping("/studentPWD")
    public ApiResult updatePwd(@RequestBody Student student){
        int res=studentService.updatePwd(student);
        if(res==1){
            return ApiResultHandler.buildApiResult(200,"修改成功",null);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"修改失败",null);
        }
    }

    /**
     * 添加一条学生记录
     * @param student
     * @return
     */
    @PostMapping("/student")
    public ApiResult add(@RequestBody Student student){
        int res=studentService.add(student);
        if(res==1){
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }

    }
}

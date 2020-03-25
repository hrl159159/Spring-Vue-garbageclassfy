package com.hrl.gagbageclassfy.Controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.ExamManage;
import com.hrl.gagbageclassfy.Service.ServiceImpl.ExamManagerServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ExamManagerController {

    @Autowired
    private ExamManagerServiceImpl examManagerservice;

    /**
     * 不分页查询所有试卷信息
     * @return
     */
    @GetMapping("/exams")
    public ApiResult findall(){
        int a=3;

        System.out.println("不分页查询所有试题");
        ApiResult apiResult;
        apiResult= ApiResultHandler.buildApiResult(200,"请求成功！",examManagerservice.findall());
        return apiResult;
    }

    /**
     * 分页查询所有试卷信息
     */
    @GetMapping("/exams/{page}/{size}")
    public ApiResult findall(@PathVariable("page")Integer page,@PathVariable("size") Integer size){
        ApiResult apiResult;
        Page<ExamManage> examManagerPage=new Page<>(page,size);
        apiResult=ApiResultHandler.buildApiResult(200,"请求成功",examManagerservice.findall(examManagerPage));

        System.out.println("分页查询所有试卷信息");
        return apiResult;
    }

    /**
     * 通过试卷号查找试卷
     */
    @GetMapping("/exam/{examCode}")
    public ApiResult findById(@PathVariable("examCode") Integer Examcode) {
        System.out.println("通过试卷号查找试卷");
        ExamManage res = examManagerservice.findById(Examcode);
        if (res == null) {
            ApiResultHandler.buildApiResult(10000, "考试编号不存在", null);
        }
            return ApiResultHandler.buildApiResult(200, "请求成功", res);

    }

    @DeleteMapping("/exam/{examCode}")
    public ApiResult deleteById(@PathVariable("examCode")Integer examCode){
        System.out.println("通过考试号删除考试");
        int res= examManagerservice.deleteById(examCode);
        if (res == 0) {
            ApiResultHandler.buildApiResult(10000, "考试编号不存在", null);
        }
        return ApiResultHandler.buildApiResult(200, "请求成功", res);

    }

    @PutMapping("/exam/{examCode}")
    public ApiResult updateById(@PathVariable("examCode")Integer examCode){
        System.out.println("通过试卷号查更新试卷");
        int res= examManagerservice.deleteById(examCode);
        if (res == 0) {
            ApiResultHandler.buildApiResult(10000, "考试编号不存在", null);
        }
        return ApiResultHandler.buildApiResult(200, "请求成功", res);

    }

    /**
     * 添加考试
     * @param examManage
     * @return
     */
    @PostMapping("/exam")
    public ApiResult add(@RequestBody ExamManage examManage){
        int res=examManagerservice.add(examManage);
        return ApiResultHandler.buildApiResult(200,"添加成功",res);
    }

    /**
     *查找最后一条记录的paperId,返回给前端实现自增
     * @return
     */
    @GetMapping("/examManagePaperId")
    public ApiResult findOnlyBypaperId(){
        ExamManage res=examManagerservice.findOnlyOaperId();
        if(res!=null){
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return  ApiResultHandler.buildApiResult(400,"请求失败",null);
    }


}

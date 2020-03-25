package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.JudgeQuestion;
import com.hrl.gagbageclassfy.Service.ServiceImpl.JudgeQuestionServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeQuestionController {

    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;

    /**
     * 添加判断题
     * @param judgeQuestion
     * @return
     */
    @PostMapping("/judgeQuestion")
    public ApiResult add(@RequestBody JudgeQuestion judgeQuestion){
        int res=judgeQuestionService.add(judgeQuestion);
        if(res!=0){
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        }
    }

    /**
     * 获取最新插入题目的id
     * @return
     */
    @GetMapping("/judgeQuestionId")
    public ApiResult findOnlyQuestionId(){
        JudgeQuestion res=judgeQuestionService.findOnlyQuestionId();
        if(res!=null){
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"请求失败",res);
        }
    }
}

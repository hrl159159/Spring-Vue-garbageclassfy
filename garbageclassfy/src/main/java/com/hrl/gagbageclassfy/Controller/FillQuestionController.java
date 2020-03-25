package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.FillQuestion;
import com.hrl.gagbageclassfy.Service.ServiceImpl.FillQuestionServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillQuestionController {

    @Autowired
    private FillQuestionServiceImpl fillQuestionService;
    /**
     * 添加判断题
     * @param
     * @return
     */
    @PostMapping("/fillQuestion")
    public ApiResult add(@RequestBody FillQuestion fillQuestion){
        int res=fillQuestionService.add(fillQuestion);
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
    @GetMapping("/fillQuestionId")
    public ApiResult findOnlyQuestionId(){
        FillQuestion res=fillQuestionService.findOnlyQuestionId();
        if(res!=null){
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"请求失败",res);
        }
    }
}

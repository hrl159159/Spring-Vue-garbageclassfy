package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.MultiQuestion;
import com.hrl.gagbageclassfy.Service.ServiceImpl.MultiQuestionServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiQuestionController {
    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;

    /**
     * 添加选择题
     * @param multiQuestion
     * @return
     */
    @PostMapping("/MultiQuestion")
    public ApiResult add(@RequestBody MultiQuestion multiQuestion){
            int res=multiQuestionService.add(multiQuestion);
            if(res==0){
                return ApiResultHandler.buildApiResult(400,"添加失败",res);
            }
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
    }

    /**
     * 通过"/MultiQuestion"添加了一条题目进去multiquestion表，但是还没将题目添加到试卷上
     * 所以要获取该题目的Id,然后将它添加到papermanage表中，该表是用来将题目与试卷对应起来
     * @return
     */
    @GetMapping("/multiQuestionId")
    public ApiResult findOnlyQuestion(){
        MultiQuestion res=multiQuestionService.findOnlyQuestionId();
        if(res!=null)
        {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
       return ApiResultHandler.buildApiResult(400,"添加失败",res);

    }



}

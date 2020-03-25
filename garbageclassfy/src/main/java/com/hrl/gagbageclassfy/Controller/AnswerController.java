package com.hrl.gagbageclassfy.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Service.ServiceImpl.AnswerVOServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import com.hrl.gagbageclassfy.VO.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @Autowired
    private AnswerVOServiceImpl answerVOService;

    /**
     * 查询所有题库
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/answers/{page}/{size}")
    public ApiResult findAll(@PathVariable("page")Integer page,@PathVariable("size") Integer size){
        Page<AnswerVO> answerVOPage=new Page<>(page,size);
        IPage<AnswerVO> answerVOIPage=answerVOService.findAll(answerVOPage);
            return ApiResultHandler.buildApiResult(200,"查询所有题库",answerVOIPage);
    }
}

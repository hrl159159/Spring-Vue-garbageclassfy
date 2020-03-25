package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.DAO.PaperManageDAO;
import com.hrl.gagbageclassfy.Entity.*;
import com.hrl.gagbageclassfy.Service.ServiceImpl.FillQuestionServiceImpl;
import com.hrl.gagbageclassfy.Service.ServiceImpl.JudgeQuestionServiceImpl;
import com.hrl.gagbageclassfy.Service.ServiceImpl.MultiQuestionServiceImpl;
import com.hrl.gagbageclassfy.Service.ServiceImpl.PaperManageServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaperManageController {

    @Autowired
    private PaperManageServiceImpl paperManageService;

    @Autowired
    private JudgeQuestionServiceImpl judgeQuestionService;

    @Autowired
    private FillQuestionServiceImpl fillQuestionService;

    @Autowired
    private MultiQuestionServiceImpl multiQuestionService;


    @GetMapping("/paper")
    public ApiResult<PaperManage> findAll(){
    ApiResult apiResult= ApiResultHandler.buildApiResult(200,"请求成功",paperManageService.findAll());
    return apiResult;
    }

    /**
     * 通过试卷编号来找查找试卷内容
     * @param paperId
     * @return
     */
    @GetMapping("/paper/{paperId}")
    public Map<Integer, List<?>> findById(@PathVariable("paperId")Integer paperId){
        List<MultiQuestion> multiQuestionList=multiQuestionService.findByIdAndType(paperId);
        List<FillQuestion> fillQuestionList=fillQuestionService.findByIdAndType(paperId);
        List<JudgeQuestion> judgeQuestionList=judgeQuestionService.findByIdAndType(paperId);
        Map<Integer,List<?>> map=new HashMap<>();
        map.put(1,multiQuestionList);
        map.put(2,fillQuestionList);
        map.put(3,judgeQuestionList);
        return map;
    }

    /**
     * 将新增的题目添加到试卷上
     * @param paperManage
     * @return
     */
    @PostMapping("/paperManage")
    public ApiResult add(@RequestBody PaperManage paperManage){
        System.out.println("将新增的题目添加到试卷上");
        int res=paperManageService.add(paperManage);
        if(res!=0){
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"添加失败",res);
        }
    }
}

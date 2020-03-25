package com.hrl.gagbageclassfy.Controller;

import com.hrl.gagbageclassfy.Entity.ApiResult;
import com.hrl.gagbageclassfy.Entity.Score;
import com.hrl.gagbageclassfy.Service.ServiceImpl.ScoreServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    private ScoreServiceImpl scoreService;

    /**
     * 查找所有学生成绩
     * @return
     */
    @GetMapping("/scores")
    public ApiResult findAll(){
        System.out.println("查找所有学生成绩");
        List<Score> res=scoreService.findAll();
        return ApiResultHandler.buildApiResult(200,"查找所有学生成绩",res);
    }

    /**
     * 前端提交试卷后将成绩存进数据库
     * @param score
     * @return
     */
    @PostMapping("/score")
    public ApiResult add(@RequestBody Score score){
        int res=scoreService.add(score);
        if(res==0){
            return ApiResultHandler.buildApiResult(400,"成绩添加失败",null);
        }
        else {
            return ApiResultHandler.buildApiResult(200,"成绩添加成功",res);
        }
    }

    /**
     *根据学生Id查找成绩
     */
    @GetMapping("/score/{studentId}")
    public ApiResult findById(@PathVariable("studentId")Integer studentId){
        List<Score> scoreList=scoreService.findById(studentId);
        if (scoreList.isEmpty()){
            return ApiResultHandler.buildApiResult(400,"Id不存在",scoreList);
        }
        else {
            return ApiResultHandler.buildApiResult(200,"根据Id查找成绩",scoreList);
        }
    }
}

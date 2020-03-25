package com.hrl.gagbageclassfy.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.*;
import com.hrl.gagbageclassfy.Service.ServiceImpl.HazardousServiceImpl;
import com.hrl.gagbageclassfy.Util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HazardousController {
    @Autowired
    private HazardousServiceImpl hazardousService;

    /**
     * 查找所有可回收物信息
     * @return
     */
    @GetMapping("/recyclable/{page}/{size}")
    public ApiResult findAllRecyclable(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        ApiResult apiResult;
        Page<Recyclable> recyclablePage=new Page<>(page,size);
        apiResult=ApiResultHandler.buildApiResult(200,"请求成功",hazardousService.findAllRecylable(recyclablePage));
        return apiResult;
    }

    /**
     * 查找所有有害垃圾信息
     * @return
     */
    @GetMapping("/hazardous/{page}/{size}")
    public ApiResult findAllHazardous(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Page<Hazardous> hazardousPage=new Page<>(page,size);
        IPage<Hazardous> hazardousIPage=hazardousService.findAllHazardous(hazardousPage);
        return ApiResultHandler.buildApiResult(200,"请求成功",hazardousIPage);
    }

    /**
     * 查找所有湿垃圾信息
     * @return
     */
    @GetMapping("/household/{page}/{size}")
    public ApiResult findAllHousehold(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Page<Householdfood> householdfoodPage=new Page<>(page,size);
        IPage<Householdfood> householdfoodIPage=hazardousService.findAllhousehold(householdfoodPage);
        return ApiResultHandler.buildApiResult(200,"请求成功",householdfoodIPage);
    }

    /**
     * 查找所有干垃圾信息
     * @return
     */
    @GetMapping("/residual/{page}/{size}")
    public ApiResult findAllResidual(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Page<Residual> residualPage=new Page<>(page,size);
        IPage<Residual> residualIPage=hazardousService.findAllresidual(residualPage);
        return ApiResultHandler.buildApiResult(200,"请求成功",residualIPage);
    }

    /**
     * 根据垃圾名称查找
     * @param
     * @return
     */
    @GetMapping("/hazardousName/{key}")
    public ApiResult findByName(@PathVariable("key") String key){
        String name=key+"\n";
        System.out.println(name);

        //判断是否是可回收物
        List<Recyclable> recyclableList=hazardousService.findByRecylableName(name);
        if(recyclableList.size()!=0){
            String res="可回收物";
            return ApiResultHandler.buildApiResult(200,"查找成功",res);
        }

        //判断是否是有害垃圾
        List<Hazardous> hazardousList=hazardousService.findByHazardousName(name);
        if (hazardousList.size()!=0){
            String res="有害垃圾";
            return ApiResultHandler.buildApiResult(200,"查找成功",res);
        }

        //判断是否是湿垃圾
        List<Householdfood> householdfoodList=hazardousService.findByhouseholdName(name);
        if(householdfoodList.size()!=0){
            String res="湿垃圾";
            return ApiResultHandler.buildApiResult(200,"查找成功",res);
        }

        //判断是否是干垃圾
        List<Residual> residualList=hazardousService.findByresidualName(name);
        if(residualList.size()!=0){
            String res="干垃圾";
            return ApiResultHandler.buildApiResult(200,"查找成功",res);
        }
        else {
            return ApiResultHandler.buildApiResult(400,"查找失败",null);
        }
    }
}

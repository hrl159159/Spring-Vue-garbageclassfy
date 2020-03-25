package com.hrl.gagbageclassfy.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.DAO.HazardousDAO;
import com.hrl.gagbageclassfy.Entity.Hazardous;
import com.hrl.gagbageclassfy.Entity.Householdfood;
import com.hrl.gagbageclassfy.Entity.Recyclable;
import com.hrl.gagbageclassfy.Entity.Residual;

import java.util.List;

public interface HazardousService {

    /**
     * 查找所有可回收物
     * @return
     */

    IPage<Recyclable> findAllRecylable(Page page);

    /**
     * 查找所有有害垃圾
     * @return
     */

    IPage<Hazardous> findAllHazardous(Page page);



    /**
     * 查找所有湿垃圾
     * @return
     */

    IPage<Householdfood> findAllhousehold(Page page);

    /**
     * 查找所有干垃圾
     * @return
     */

    IPage<Residual> findAllresidual(Page page);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */

    List<Recyclable> findByRecylableName(String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */

    List<Hazardous> findByHazardousName(String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */

    List<Householdfood> findByhouseholdName(String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */

    List<Residual> findByresidualName(String name);
}

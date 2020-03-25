package com.hrl.gagbageclassfy.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.Hazardous;
import com.hrl.gagbageclassfy.Entity.Householdfood;
import com.hrl.gagbageclassfy.Entity.Recyclable;
import com.hrl.gagbageclassfy.Entity.Residual;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HazardousDAO {

    /**
     * 查找所有可回收物
     * @return
     */
    @Select("select * from recyclable_waste")
    IPage<Recyclable> findAllRecylable(Page page);

    /**
     * 查找所有有害垃圾
     * @return
     */
    @Select("select * from hazardous_waste")
    IPage<Hazardous> findAllHazardous(Page page);



    /**
     * 查找所有湿垃圾
     * @return
     */
    @Select("select * from householdfood_waste")
    IPage<Householdfood> findAllhousehold(Page page);

    /**
     * 查找所有干垃圾
     * @return
     */
    @Select("select * from residual_waste")
    IPage<Residual> findAllresidual(Page page);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */
    @Select("select * from recyclable_waste where recname = #{name}")
    List<Recyclable> findByRecylableName(@Param("name") String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */
    @Select("select * from hazardous_waste where hazname = #{name}")
    List<Hazardous> findByHazardousName(@Param("name") String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */
    @Select("select * from householdfood_waste where houname = #{name}")
    List<Householdfood> findByhouseholdName(@Param("name") String name);

    /**
     * 根据垃圾名称查询所属类别
     * @param name
     * @return
     */
    @Select("select * from residual_waste where resname = #{name}")
    List<Residual> findByresidualName(@Param("name") String name);
}

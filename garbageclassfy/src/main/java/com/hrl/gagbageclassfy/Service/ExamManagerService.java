package com.hrl.gagbageclassfy.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.ExamManage;

import java.util.List;

public interface ExamManagerService {
    /**
     * 获取所有试卷信息
     */
    List<ExamManage> findall();


    /**
     * 分页查询所有试卷信息
     * @param page
     * @return
     */
    IPage<ExamManage> findall(Page<ExamManage> page);

    /**
     * 通过试卷号查找试卷
     */
    ExamManage findById(Integer Examcode);

    /**
     *通过试卷号删除试卷
     */
    int deleteById(Integer Examcode);

    /**
     * 通过试卷号修改试卷
     */

    int update(ExamManage examManage);

    /**
     * 添加考试
     * useGeneratedKeys=true时表示该表id以自增列为主键，并允许JDBC自动生成主键
     */
    int add(ExamManage examManage);


    ExamManage findOnlyOaperId();
}

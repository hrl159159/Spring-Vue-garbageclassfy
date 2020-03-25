package com.hrl.gagbageclassfy.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.VO.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswerDAO {

    @Select("select question, subject, score, section,level, \"选择题\" as type from multiquestion " +
            "union select  question, subject, score, section,level, \"判断题\" as type  from judgequestion " +
            "union select  question, subject, score, section,level, \"填空题\" as type from fillquestion")
    IPage<AnswerVO> findAll(Page page);
}

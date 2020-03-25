package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.FillQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FillQuestionDAO {

    @Select("select * from Fillquestion where questionid in (select questionid from papermanage where questiontype =2 and paperid = #{paperId})")
    List<FillQuestion> findByIdAndType(Integer paperId);


    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into fillquestion(subject,question,answer,score,analysis,level,section) values " +
            "(#{subject,},#{question},#{answer},#{score},#{analysis},#{level},#{section})")
    int add(FillQuestion fillQuestion);


    /**
     *根据最新插入的题目的Id查找题目
     * @return
     */
    @Select("select questionId from fillQuestion order by questionId desc limit 1")
    FillQuestion findOnlyQuestionId();
}

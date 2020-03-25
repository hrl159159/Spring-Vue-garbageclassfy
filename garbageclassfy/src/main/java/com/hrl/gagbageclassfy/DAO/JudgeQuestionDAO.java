package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.JudgeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JudgeQuestionDAO {

    @Select("select * from judgequestion where questionid in (select questionid from papermanage where questiontype =3 and paperid = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    @Insert("insert into judgequestion(subject,question,answer,score,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{score},#{analysis},#{level},#{section})")
    int add(JudgeQuestion judgeQuestion);

    /**
     *根据最新插入的题目的Id查找题目
     * @return
     */
    @Select("select questionId from judgeQuestion order by questionId desc limit 1")
    JudgeQuestion findOnlyQuestionId();
}

package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.JudgeQuestion;
import com.hrl.gagbageclassfy.Entity.MultiQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MultiQuestionDAO {

    /**
     * 根据Id或者类型查找题目
     * @param paperId
     * @return
     */
    @Select("select * from Multiquestion where questionid in (select questionid from papermanage where questiontype =1 and paperid = #{paperId})")
    List<MultiQuestion> findByIdAndType(Integer paperId);


    /**
     * 新增题目
     * @param multiQuestion
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "questionId")
    @Insert("insert into multiquestion(subject,question,answerA,answerB,answerC,answerD,rightAnswer,score,analysis,section,level) " +
            "values(#{subject},#{question},#{answerA},#{answerB},#{answerC},#{answerD},#{rightAnswer},#{score},#{analysis},#{section},#{level})")
    int add(MultiQuestion multiQuestion);

    /**
     *根据最新插入的题目的Id查找题目
     * @return
     */
    @Select("select questionId from multiquestion order by questionId desc limit 1")
    MultiQuestion findOnlyQuestionId();
}

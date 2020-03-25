package com.hrl.gagbageclassfy.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrl.gagbageclassfy.Entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface ScoreDAO {


    /**
     * 插入一条成绩记录
     * @param score
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(examcode,studentid,subject,ptscore,etscore,score,answerdate) values(#{examCode},#{studentId},#{subject},#{ptScore},#{etScore},#{score},#{answerDate}) ")
    int add(Score score);

    /**
     * 查找所有成绩记录
     */
    @Select("select * from score")
    List<Score> findAll();

    /**
     * 根据学生Id查找成绩
     */
    @Select("select * from score where studentid=#{studentId}")
    List<Score> findById(Integer studentId);
}

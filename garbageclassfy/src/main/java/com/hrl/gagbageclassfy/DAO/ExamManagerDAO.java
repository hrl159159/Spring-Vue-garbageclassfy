package com.hrl.gagbageclassfy.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.ExamManage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamManagerDAO {

    /**
     * 查找全部试卷信息
     */
    @Select("select * from exammanage")
    List<ExamManage> findall();

    @Select("select * from ExamManage")
    IPage<ExamManage> findAll(Page page);

    /**
     * 通过试卷号查找试卷
     */

    @Select("select * from exammanage where examcode = #{Examcode}")
    ExamManage findById(Integer Examcode);

    /**
     *通过试卷号删除试卷
     */
    @Delete("delete from exammanage where examcode=#{Examcode}")
    int deleteById(Integer Examcode);

    /**
     * 通过试卷号修改试卷
     */
    @Update("update ExamManage set description = #{description},source = #{source},paperId = #{paperId}," +
            "examDate = #{examDate},totalTime = #{totalTime},grade = #{grade},term = #{term}," +
            "major = #{major},institute = #{institute},totalScore = #{totalScore}," +
            "type = #{type},tips = #{tips} where examCode = #{examCode}")
    int update(ExamManage examManage);

    /**
     * 添加考试
     * useGeneratedKeys=true时表示该表id以自增列为主键，并允许JDBC自动生成主键
     */
    @Options(useGeneratedKeys = true,keyProperty = "examCode")
    @Insert("insert into ExamManage(description,source,paperId,examDate,totalTime,grade,term,major,institute,totalScore,type,tips)" +
            " values(#{description},#{source},#{paperId},#{examDate},#{totalTime},#{grade},#{term},#{major},#{institute},#{totalScore},#{type},#{tips})")
    int add(ExamManage examManage);

    /**
     * 查找最后一条记录的paperId,返回给前端实现自增
     * @return
     */
    @Select("select paperId from exammanage order by paperId limit 1")
    ExamManage findOnlyOaperId();
}

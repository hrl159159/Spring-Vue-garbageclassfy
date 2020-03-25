package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherDAO {

    @Select("select * from teacher where teacherId = #{username} and pwd = #{password}")
    Teacher findByIdAndPwd(Integer username,String password);

    @Select("select * from teacher")
    List<Teacher> findAll();

    @Delete("delete from teacher where teacherId = #{teacherId}")
    int deleteById(Integer teacherId);

    @Update("update teacher set teacherName = #{teacherName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId}," +
            "role = #{role},institute = #{institute},type = #{type} where teacherId = #{teacherId}")
    int updateById(Teacher teacher);

    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
    @Insert("insert into teacher(teacherName,sex,tel,email,pwd,cardId,role,type,institute)"+
            "values(#{teacherName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role},#{type},#{institute})")
    int add(Teacher teacher);
}

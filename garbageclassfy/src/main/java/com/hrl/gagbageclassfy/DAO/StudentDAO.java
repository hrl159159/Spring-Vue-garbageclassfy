package com.hrl.gagbageclassfy.DAO;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.Entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentDAO {

    /**
     * 分页查询所有学生信息
     * @return
     */
    @Select("select * from student")
    IPage<Student> findAll(Page<Student> studentPage);

    /**
     * 通过Id查询一个学生记录
     * @param studentId
     * @return
     */
    @Select("select * from student where studentId=#{studentId}")
    Student findById(Integer studentId);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Update("update student set studentName = #{studentName},grade = #{grade},major = #{major},clazz = #{clazz}," +
            "institute = #{institute},tel = #{tel},email = #{email},pwd = #{pwd},cardId = #{cardId},sex = #{sex},role = #{role} " +
            "where studentId = #{studentId}")
    int updateById(Student student);

    /**
     * 通过学生Id删除一条学生记录
     * @param studentId
     * @return
     */
    @Delete("delete from student where studentId=#{studentId}")
    int deleteById(Integer studentId);

    /**
     * 修改密码
     * @param student
     * @return
     */
    @Update("update student set pwd=#{pwd}")
    int updatePwd(Student student);

    /**
     * 添加一个学生记录
     * @param student
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "studentId")
    @Insert("insert into student(studentName,grade,major,clazz,institute,tel,email,pwd,cardId,sex,role) values " +
            "(#{studentName},#{grade},#{major},#{clazz},#{institute},#{tel},#{email},#{pwd},#{cardId},#{sex},#{role})")
    int add(Student student);
}

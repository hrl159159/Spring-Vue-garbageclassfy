package com.hrl.gagbageclassfy.DAO;

import com.hrl.gagbageclassfy.Entity.PaperManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperManageDAO {

    /**
     * 查找所有
     * @return
     */
    @Select("select * from papermanage")
    List<PaperManage> findAll();

    @Insert("insert into papermanage(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(PaperManage paperManage);


}

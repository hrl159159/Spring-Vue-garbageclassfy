package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.Score;

import java.util.List;

public interface ScoreService {

    /**
     * 插入一条成绩记录
     * @param score
     * @return
     */

    int add(Score score);

    /**
     * 查找所有成绩记录
     */

    List<Score> findAll();

    /**
     * 根据学生Id查找成绩
     */

    List<Score> findById(Integer studentId);
}

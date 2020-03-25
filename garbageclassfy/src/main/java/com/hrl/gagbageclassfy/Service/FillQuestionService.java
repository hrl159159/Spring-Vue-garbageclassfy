package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.FillQuestion;

import java.util.List;

public interface FillQuestionService {
    List<FillQuestion> findByIdAndType(Integer paperId);


    int add(FillQuestion fillQuestion);

    /**
     *根据最新插入的题目的Id查找题目
     * @return
     */
    FillQuestion findOnlyQuestionId();
}

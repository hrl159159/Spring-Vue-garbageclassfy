package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.JudgeQuestion;

import java.util.List;

public interface JudgeQuestionService {
    List<JudgeQuestion> findByIdAndType(Integer paperId);

    int add(JudgeQuestion judgeQuestion);

    JudgeQuestion findOnlyQuestionId();
}

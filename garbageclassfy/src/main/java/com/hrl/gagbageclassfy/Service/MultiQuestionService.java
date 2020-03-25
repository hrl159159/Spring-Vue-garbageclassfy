package com.hrl.gagbageclassfy.Service;

import com.hrl.gagbageclassfy.Entity.MultiQuestion;

import java.util.List;

public interface MultiQuestionService {
    List<MultiQuestion> findByIdAndType(Integer paperId);

    int add(MultiQuestion multiQuestion);

    MultiQuestion findOnlyQuestionId();
}

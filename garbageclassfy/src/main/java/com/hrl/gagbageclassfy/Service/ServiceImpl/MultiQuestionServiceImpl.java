package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.MultiQuestionDAO;
import com.hrl.gagbageclassfy.Entity.MultiQuestion;
import com.hrl.gagbageclassfy.Service.MultiQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiQuestionServiceImpl implements MultiQuestionService {
    @Autowired
    private MultiQuestionDAO multiQuestionDAO;
    @Override
    public List<MultiQuestion> findByIdAndType(Integer paperId) {
        return multiQuestionDAO.findByIdAndType(paperId);
    }

    @Override
    public int add(MultiQuestion multiQuestion) {
        return multiQuestionDAO.add(multiQuestion);
    }

    @Override
    public MultiQuestion findOnlyQuestionId() {
        return multiQuestionDAO.findOnlyQuestionId();
    }
}

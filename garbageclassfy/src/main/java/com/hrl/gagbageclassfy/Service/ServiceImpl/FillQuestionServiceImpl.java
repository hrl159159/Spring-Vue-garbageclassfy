package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.FillQuestionDAO;
import com.hrl.gagbageclassfy.Entity.FillQuestion;
import com.hrl.gagbageclassfy.Service.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillQuestionServiceImpl implements FillQuestionService {
    @Autowired
    private FillQuestionDAO fillQuestionDAO;
    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionDAO.findByIdAndType(paperId);
    }

    @Override
    public int add(FillQuestion fillQuestion) {
        return fillQuestionDAO.add(fillQuestion);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionDAO.findOnlyQuestionId();
    }
}

package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.hrl.gagbageclassfy.DAO.JudgeQuestionDAO;
import com.hrl.gagbageclassfy.Entity.JudgeQuestion;
import com.hrl.gagbageclassfy.Service.JudgeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeQuestionServiceImpl implements JudgeQuestionService {
    @Autowired
    private JudgeQuestionDAO judgeQuestionDAO;
    @Override
    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionDAO.findByIdAndType(paperId);
    }

    @Override
    public int add(JudgeQuestion judgeQuestion) {
        return judgeQuestionDAO.add(judgeQuestion);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionDAO.findOnlyQuestionId();
    }
}

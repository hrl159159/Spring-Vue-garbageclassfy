package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.DAO.AnswerDAO;
import com.hrl.gagbageclassfy.Service.AnswerVOService;
import com.hrl.gagbageclassfy.VO.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerVOServiceImpl implements AnswerVOService {
    @Autowired
    private AnswerDAO answerDAO;
    @Override
    public IPage<AnswerVO> findAll(Page page) {
        return answerDAO.findAll(page);
    }
}

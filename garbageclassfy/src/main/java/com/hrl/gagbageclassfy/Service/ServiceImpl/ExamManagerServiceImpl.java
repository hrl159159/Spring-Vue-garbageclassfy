package com.hrl.gagbageclassfy.Service.ServiceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrl.gagbageclassfy.DAO.ExamManagerDAO;
import com.hrl.gagbageclassfy.Entity.ExamManage;
import com.hrl.gagbageclassfy.Service.ExamManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManagerServiceImpl implements ExamManagerService {

    @Autowired
    private ExamManagerDAO examManagerDAO;
    @Override
    public List<ExamManage> findall() {
        return examManagerDAO.findall();
    }

    @Override
    public IPage<ExamManage> findall(Page<ExamManage> page) {
        return examManagerDAO.findAll(page);
    }

    @Override
    public ExamManage findById(Integer Examcode) {
        return examManagerDAO.findById(Examcode);
    }

    @Override
    public int deleteById(Integer Examcode) {
        return examManagerDAO.deleteById(Examcode);
    }

    @Override
    public int update(ExamManage examManage) {
        return examManagerDAO.update(examManage);
    }

    @Override
    public int add(ExamManage examManage) {
        return examManagerDAO.add(examManage);
    }

    @Override
    public ExamManage findOnlyOaperId() {
        return examManagerDAO.findOnlyOaperId();
    }

}
